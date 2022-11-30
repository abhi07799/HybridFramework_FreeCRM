package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.*;
import com.freecrm.util.AllureReportListener;

import io.qameta.allure.Description;


@Listeners({AllureReportListener.class})
public class LogInPageTest extends TestBase
{
	LogInPage lip;
	HomePage hp;
	
	public LogInPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		lip=new LogInPage();
	}
	
	@Test(priority = 1)
	@Description("To Verify Logo Is Displayed")
	public void validateLogo()
	{
		boolean flag=lip.crmLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	@Description("To Verify Title")
	public void validateTitle()
	{
		String title = lip.crmTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=3)
	@Description("To Verify That User Is Unable To Login Using Wrong Credentials")
	public void validateLogin_WrongCredentials()
	{
		lip.logIn_Invalid(prp.getProperty("userName_In"), prp.getProperty("Password_In"));
		String title=lip.crmTitle();
		Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=4)
	@Description("To Verify That User Is Able To Login Using Valid Credentials")
	public void validateLogin()
	{
		hp=lip.logIn(prp.getProperty("userName_V"), prp.getProperty("Password_V"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
