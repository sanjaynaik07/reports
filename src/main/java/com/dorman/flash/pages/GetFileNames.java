package com.dorman.flash.pages;

import java.io.File;

public class GetFileNames {
	
	public File[] getnames(String path)
	{
		
		String path1=path;
		System.out.println(path1);
		File folder = new File(path1);
		File[] QA_listOfFiles = folder.listFiles();	
	System.out.println("in fasak");
	return QA_listOfFiles;

}
}