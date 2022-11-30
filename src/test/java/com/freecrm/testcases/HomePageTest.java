package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.*;
import com.freecrm.pages.*;
import com.freecrm.util.TestUtil;

import io.qameta.allure.Description;

public class HomePageTest extends TestBase
{
	HomePage hp;
	LogInPage lp;
	TestUtil utl;
	ContactsPage cp;
	
	public HomePageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		utl = new TestUtil();
		lp = new LogInPage();
		hp = lp.logIn(prp.getProperty("userName_V"), prp.getProperty("Password_V"));
	}
	
	//Actions
	
	@Test(priority=1)
	@Description("To Verify User Name Displayed")
	public void verifyUserNameDisplayed()
	{
		utl.switchToFrame();
		Assert.assertTrue(hp.userNameDisplayed());
	}
	
	@Test(priority=2)
	@Description("To Verify Title Is Correct")
	public void verifyTitle()
	{
		String title = hp.homePageTitle();
		Assert.assertEquals(title, "CRMPRO","Title Not Matched");
	}
	
	@Test(priority=3)
	@Description("To Verify Calendar Page")
	public void  verifyCalendarPage()
	{
		utl.switchToFrame();
		Assert.assertTrue(hp.clickCalendar());
	}
	
	@Test(priority=4)
	@Description("To Verify Companies Page")
	public void verifyCompaniesPage()
	{
		utl.switchToFrame();
		Assert.assertTrue(hp.cilckCompanies());
	}
	
	@Test(priority=5)
	@Description("To Verify Contacts Page")
	public void moveToContactsPage()
	{
		utl.switchToFrame();
		Assert.assertTrue(hp.clickContacts());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
