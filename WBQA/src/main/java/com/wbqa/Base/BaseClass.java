package com.wbqa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.wbqa.util.ExtentManager;
import com.wbqa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
   public static Logger logger;
   
   
   @BeforeSuite
	public void loadConfig() 
	{
	   ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try
		{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("/Users/lakshmi/eclipse-workspace/WBQA/src/main/java/com/wbqa/config/config.properties");
		prop.load(fis);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
		}catch(IOException e) {
		e.printStackTrace();
		}
	}
	
	public static void intialization()
	{
		// logger=Logger.getLogger("WBQA");
		// PropertyConfigurator.configure("log4j.properties");
		
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			  WebDriverManager.chromiumdriver().setup();
			  driver= new ChromeDriver();
			
		       }else if(browserName.equals("firefox")) {
					  WebDriverManager.firefoxdriver().setup();
					  driver= new FirefoxDriver();
	  }
		driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  
	     
	     driver.get(prop.getProperty("url"));
	     
	     
	}
	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void afterSuite() {
		 ExtentManager.endReport();
	}
	
}
