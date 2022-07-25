package com.wbqa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wbqa.Base.BaseClass;


public class LoginPage extends BaseClass{

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[@id='login']")
	WebElement loginbtn;

	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		}

	// Actions
	

	public LandingPage loginmethod(String un, String pwd)throws IOException {

		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new LandingPage();
	}

/*	public LandingPage loginmethod1(String Username, String Password) {
		loginbtn.click();
		return new LandingPage();
		
	} */
	
	
}

	


