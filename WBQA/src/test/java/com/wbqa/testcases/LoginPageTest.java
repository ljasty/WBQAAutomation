package com.wbqa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbqa.Base.BaseClass;
import com.wbqa.pages.HomePage;
import com.wbqa.pages.LoginPage;
import com.wbqa.util.Log;
import com.wbqa.util.ReadExcelFile;
import com.wbqa.pages.LandingPage;


public class LoginPageTest extends BaseClass{
	HomePage home;
	LoginPage login;
	LandingPage land;

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		intialization();
		home=new HomePage();
		login = new LoginPage();
		land = new LandingPage();
		home.verifylogin();

	}
	
			
	
	
/*@Test
	public void loginTest() {

		land = login.loginmethod(prop.getProperty("username"), prop.getProperty("password"));
	}  */
	
	@Test(dataProvider="testdata")
		//	, dataProviderClass=DataProviders.class)
public void loginTest(String username, String password) throws IOException
	{
		Log.startTestCase("loginTest");
		Log.info("User entering Username And password");
		land = login.loginmethod(username,password);
		Log.endTestCase("End loginTest");	
	}
	
	
	@DataProvider(name="testdata")
	public Object[][] testDataExample() throws IOException{
	ReadExcelFile Re= new ReadExcelFile("/Users/lakshmi/eclipse-workspace/WBQA/src/main/java/com/wqqa/testdata/testdata.xlsx");
			
		//  /Users/lakshmi/eclipse-workspace/WBQA/src/main/java/com/wqqa/testdata/login (1).xlsx");
			
		
	int rows = Re.getRowCount(0);
	Object[][]signin_credentials = new Object[rows][2];

	for(int i=0;i<rows;i++)
	{
	signin_credentials[i][0] = Re.getData(0, i, 0);
	signin_credentials[i][1] = Re.getData(0, i, 1);
	}
	return signin_credentials;
	}
	
	@AfterMethod()
	public void TearDown() {
		driver.quit();
	}

}
	
	

