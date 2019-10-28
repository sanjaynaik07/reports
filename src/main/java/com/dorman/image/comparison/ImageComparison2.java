package com.dorman.image.comparison;

import com.dorman.image.model.Rectangle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Optional;

import static java.awt.Color.RED;
import static com.dorman.image.comparison.ImageComparisonTools2.*;

public class ImageComparison2 {

	/**
	 * The threshold which means the max distance between non-equal pixels. Could be
	 * changed according size and requirements to the image.
	 */
	public static int threshold = 5;

	public boolean IsImageSame;
	/**
	 * The number which marks how many rectangles. Beginning from 2.
	 */
	private int counter = 2;

	/**
	 * The number of the marking specific rectangle.
	 */
	private int regionCount = counter;

	private final BufferedImage image1;
	private final BufferedImage image2;
	private final /* @Nullable */ File destination;
	private int[][] matrix;

	public ImageComparison2(String image1, String image2, String result) throws IOException, URISyntaxException {
		this(readImageFromResources2(image1), readImageFromResources2(image2), new File(result));
	}

	/**
	 * Create a new instance of {@link ImageComparison2} that can compare the given
	 * images.
	 *
	 * @param image1
	 *            first image to be compared
	 * @param image2
	 *            second image to be compared
	 * @param destination
	 *            destination to save the result. If null, the result is shown in
	 *            the UI.
	 */
	public ImageComparison2(BufferedImage image1, BufferedImage image2, File destination) {
		this.image1 = image1;
		this.image2 = image2;
		this.destination = destination;
	}

	public BufferedImage getImage1() {
		return image1;
	}

	public BufferedImage getImage2() {
		return image2;
	}

	Optional<File> getDestination() {
		return Optional.ofNullable(destination);
	}

	public static void main(String[] args) throws IOException, URISyntaxException {
		ImageComparison2 imgCmp = create(args);
		BufferedImage result = imgCmp.compareImages2();
		handleResult(imgCmp, (file) -> saveImage(file, result), () -> createGUI(result));
	}

	static ImageComparison2 create(String... args) throws IOException, URISyntaxException {
		Optional<ArgsParser.Arguments> arguments = new ArgsParser().parseArgs(args);
		return arguments.isPresent() ? create(arguments.get()) : createDefault();
	}

	static ImageComparison2 createDefault() throws IOException, URISyntaxException {
		return new ImageComparison2(readImageFromResources2("image1.png"), readImageFromResources2("image2.png"), null);
	}

	static ImageComparison2 create(ArgsParser.Arguments args) throws IOException {
		return new ImageComparison2(readImageFromFile(args.getImage1()), readImageFromFile(args.getImage2()),
				args.getDestinationImage().orElse(null));
	}

	static void handleResult(ImageComparison2 instance, IOConsumer<File> saveToFile, Runnable showUI)
			throws IOException {
		if (instance.getDestination().isPresent()) {
			saveToFile.accept(instance.getDestination().get());
		} else {
			showUI.run();
		}
	}

	/**
	 * Draw rectangles which cover the regions of the difference pixels.
	 * 
	 * @return the result of the drawing.
	 */
	public BufferedImage compareImages2() throws IOException {
		// check images for valid
		checkCorrectImageSize(image1, image2);

		matrix = populateTheMatrixOfTheDifferences(image1, image2);

		IsImageDifferent();

		BufferedImage outImg = deepCopy(image2);
		Graphics2D graphics = outImg.createGraphics();
		try {

			graphics.setColor(RED);
			groupRegions();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		drawRectangles(graphics);

		// save the image:
		saveImage(this.getDestination().orElse(Files.createTempFile("image-comparison", ".png").toFile()), outImg);
		return outImg;
	}

	public String IsImageDifferent() {
		boolean IsDiff = false;
		// System.out.println(matrix.length);
		int j = matrix.length;
		for (int i = 0; i < j; i++) {
			int z = matrix[i].length;
			for (int k = 0; k < z; k++) {
				// System.out.println(matrix[i][k]);
				if (matrix[i][k] > 0) {
					IsDiff = true;
					IsImageSame = false;
					break;
				}
			}
			if (IsDiff) {
				break;
			}
		}
		if (IsDiff)
		{
			System.out.println("Images are different");
			return "Images are different";
		}
		
		else
		{
			
			IsImageSame = true;
			System.out.println("Images are Same");
		
		return "Images are Same";
		}
	}

	/**
	 * Draw rectangles with the differences pixels.
	 * 
	 * @param graphics
	 *            the Graphics2D object for drawing rectangles.
	 */
	private void drawRectangles(Graphics2D graphics) {
		if (counter > regionCount)
			return;

		Rectangle rectangle = createRectangle(matrix, counter);

		graphics.drawRect(rectangle.getMinY(), rectangle.getMinX(), rectangle.getWidth(), rectangle.getHeight());
		counter++;
		try {
			drawRectangles(graphics);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Group rectangle regions in binary matrix.
	 */
	private void groupRegions() {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == 1) {
					joinToRegion(row, col);
					regionCount++;
				}
			}
		}
	}

	/**
	 * The recursive method which go to all directions and finds difference in
	 * binary matrix using {@code threshold} for setting max distance between values
	 * which equal "1". and set the {@code groupCount} to matrix.
	 * 
	 * @param row
	 *            the value of the row.
	 * @param col
	 *            the value of the column.
	 */
	private void joinToRegion(int row, int col) {
		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length || matrix[row][col] != 1)
			return;

		matrix[row][col] = regionCount;

		for (int i = 0; i < threshold; i++) {
			// goes to all directions.
			joinToRegion(row - 1 - i, col);
			joinToRegion(row + 1 + i, col);
			joinToRegion(row, col - 1 - i);
			joinToRegion(row, col + 1 + i);

			joinToRegion(row - 1 - i, col - 1 - i);
			joinToRegion(row + 1 + i, col - 1 - i);
			joinToRegion(row - 1 - i, col + 1 + i);
			joinToRegion(row + 1 + i, col + 1 + i);
		}
	}
}
