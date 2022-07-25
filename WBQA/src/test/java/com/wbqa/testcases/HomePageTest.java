package com.wbqa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wbqa.Base.BaseClass;
import com.wbqa.pages.HomePage;
import com.wbqa.pages.LoginPage;
import com.wbqa.util.Log;
import com.wbqa.util.TestUtil;


public class HomePageTest extends BaseClass{
	
	HomePage home;
	LoginPage login;
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		intialization();
		home=new HomePage();
		
	}
	
	@Test(priority=1)
	public void TestTitle() throws IOException
	{
	
		Log.startTestCase("HomePageTitleTest");
	String actualtitle = home.VerifyTitle();
	System.out.println(actualtitle);
	Log.info("HomePage Title Validation");
	//Assert.assertEquals(actualtitle, "QA/QE/SDET Training.");
	AssertJUnit.assertEquals(actualtitle, "QA/QE/SDET Training.");
	Log.info("HomePage title validation is sucessful");
	Log.endTestCase("End HomePageTitleTest");
	//TestUtil.getScreenShotPath();
	}
	
	
	@Test(priority = 3)
	public void verifywbllogoTest() {
		Log.startTestCase("verifywbllogoTest");
		Log.info("Logo Validation");
		boolean logo = home.Verifylogo();
		Assert.assertTrue(logo);
		Log.endTestCase("End verifywbllogoTest");

	}

	@Test(priority = 2)
	public void verifyfreestudentTest() {
			Log.startTestCase("verifyfreestudentTest");
			Log.info("Verifying Student Link ");
		boolean verifyfreestudent = home.verifyfreestudent();
		Assert.assertTrue(verifyfreestudent);
		Log.endTestCase(" End verifyfreestudentTest");
	}

	@Test(priority = 4)
	public void verifyloginTest() throws IOException {
		Log.startTestCase("verifyloginTest");
		Log.info("User Clicking Login Button" );
		login=home.verifylogin();
		Log.info("User is Sucessfully Login to Login Page");
		Log.endTestCase("End verifyloginTest");
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}
	

	}
	


