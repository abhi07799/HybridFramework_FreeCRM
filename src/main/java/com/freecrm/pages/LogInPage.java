package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.*;

import io.qameta.allure.Step;

public class LogInPage extends TestBase 
{
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@class=\"navbar-brand\"]")
	WebElement crmLogo;
	
	//Initializing the pageObject
	public LogInPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	@Step("To Get Landing Page Title")
	public String crmTitle()
	{
		return driver.getTitle();
	}
	
	@Step("To Check Logo Is Displayed")
	public Boolean crmLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	@Step("To Check Log In With Invalid Credentials")
	public void logIn_Invalid(String un,String psw)
	{
		username.sendKeys(un);
		password.sendKeys(psw);
		loginBtn.click();
	}
	
	@Step("To Move on To Home Page")
	public HomePage logIn(String un,String psw)
	{
		username.sendKeys(un);
		password.sendKeys(psw);
		loginBtn.click();
		
		return new HomePage();
	}
}
