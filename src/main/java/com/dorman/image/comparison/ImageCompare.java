package com.dorman.image.comparison;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ImageCompare {

	public ImageComparison2 icmp;

	

	public boolean ImgComp1(String source, String dest ,String result) throws Exception, URISyntaxException {
	//	try {
			/*icmp = new ImageComparison2("E:\\44_ImageCompare\\SSQ1.jpg", "E:\\44_ImageCompare\\SSQ3.jpg",
					"E:\\44_ImageCompare\\Result" + System.currentTimeMillis() + ".jpg");*/
			
			icmp = new ImageComparison2(source,dest,result);
			icmp.compareImages2();


			if (icmp.IsImageSame)
			{
				//Assert.assertEquals("The images matched", icmp.IsImageSame);
				return true;
			}
			
			else {
			//	Assert.assertNotSame("The images doesn't matched", icmp.IsImageSame);
				return false;
			}
		/*	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	

	/*
	 * @Test public void ImgComp2() { try { icmp = new ImageComparison("img1.png",
	 * "img2.png"); BufferedImage result = icmp.compareImages(); if
	 * (icmp.IsImageSame) Assert.assertTrue("The images matched", icmp.IsImageSame);
	 * else { ImageComparisonTools.saveImage(new File("testresult/Nachi2.png"),
	 * result); Assert.assertTrue("The images doesn't matched", icmp.IsImageSame); }
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (URISyntaxException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 * 
	 * @Test public void ImgComp3() { try { icmp = new ImageComparison("img1.png",
	 * "img4.png"); BufferedImage result = icmp.compareImages(); if
	 * (icmp.IsImageSame) Assert.assertTrue("The images matched", icmp.IsImageSame);
	 * else { ImageComparisonTools.saveImage(new File("testresult/Nachi3.png"),
	 * result); Assert.assertTrue("The images doesn't matched", icmp.IsImageSame); }
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (URISyntaxException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 * 
	 * @Test public void ImgComp4() { try { icmp = new ImageComparison("img5.jpg",
	 * "img7.jpg"); BufferedImage result = icmp.compareImages(); if
	 * (icmp.IsImageSame) Assert.assertTrue("The images matched", icmp.IsImageSame);
	 * else { ImageComparisonTools.saveImage(new File("testresult/Nachi4.png"),
	 * result); Assert.assertTrue("The images doesn't matched", icmp.IsImageSame); }
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (URISyntaxException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 * 
	 * @Test public void ImgComp5() { try { icmp = new ImageComparison("img5.jpg",
	 * "img6.jpg"); BufferedImage result = icmp.compareImages(); if
	 * (icmp.IsImageSame) Assert.assertTrue("The images matched", icmp.IsImageSame);
	 * else { ImageComparisonTools.saveImage(new File("testresult/Nachi5.png"),
	 * result); Assert.assertTrue("The images doesn't matched", icmp.IsImageSame); }
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (URISyntaxException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 */
}
}