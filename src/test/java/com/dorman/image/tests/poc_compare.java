package com.dorman.image.tests;

import java.io.File;

import org.testng.annotations.Test;

import com.dorman.image.comparison.ImageCompare;

public class poc_compare {
	
@Test(enabled=true,priority=1)
	
	public void compare() throws Exception {
	ImageCompare it=new ImageCompare();
	boolean result=it.ImgComp1("D:\\poc\\destination.jpg",
			"D:\\poc\\source.jpg",
				"D:\\poc\\result\\result1.jpg");
}
}