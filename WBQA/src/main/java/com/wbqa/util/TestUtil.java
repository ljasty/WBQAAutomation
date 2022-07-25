package com.wbqa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.wbqa.Base.BaseClass;

public class TestUtil extends BaseClass {
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	
	
	public static void getScreenShotPath() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	
	public static String takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir")+ "/screenshots/" + System.currentTimeMillis() + ".png";
         return currentDir;  
	
	}
}
