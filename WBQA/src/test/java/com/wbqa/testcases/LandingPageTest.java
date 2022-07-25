package com.wbqa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wbqa.Base.BaseClass;
import com.wbqa.pages.HomePage;
import com.wbqa.pages.LandingPage;
import com.wbqa.pages.LoginPage;
import com.wbqa.util.Log;




public class LandingPageTest extends BaseClass {

	HomePage home;
	LoginPage login;
	LandingPage land;

	public LandingPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() throws IOException {
		intialization();
		home = new HomePage();
		login = new LoginPage();
		land = new LandingPage();
		home.verifylogin();

	}



	@Test(priority = 1)
	public void verifyHomeBtn() {
		Log.startTestCase("verifyHomeBtn");
		Log.info("Verifying Home Button");
		Boolean hom = land.verifyHomebtn();
		Assert.assertTrue(hom);
		Log.endTestCase("End verifyHomeBtn");

	}

	@Test(priority = 2)
	public void verifySchBtn() {
		Log.startTestCase("verifySchBtn");
		Log.info("Validating SearchButton");
		land.verifySchedulebtn();
		Assert.assertTrue(true);
		Log.endTestCase("End verifySchBtn");
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
	 
