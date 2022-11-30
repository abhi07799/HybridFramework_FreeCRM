package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.*;
import com.freecrm.util.TestUtil;

import io.qameta.allure.Description;

public class ContactsPageTest extends TestBase
{
	LogInPage lip;
	HomePage hp;
	ContactsPage cp;
	TestUtil util;
	
	String sheetName = "contacts";
		
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		lip = new LogInPage();
		hp = lip.logIn(prp.getProperty("userName_V"), prp.getProperty("Password_V"));
		util = new TestUtil();
		util.switchToFrame();
//		cp2=new ContactsPage();
		cp=hp.initializeContactsObject();
		
	}
	
	@Test(priority=1)
	@Description("To Verify Contacts Page Label")
	public void verifyContactsPageLabel()
	{
		hp.clickContatcs();
		Assert.assertTrue(cp.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	@Description("To Verify a Single Contact Is Selected")
	public void selectSingleContactsTest()
	{
		hp.clickContatcs();
		cp.selectContactsByName("Gojo");
	}
	
	@Test(priority=3)
	@Description("To Verify Multiple Contacts Selected ")
	public void selectMultipleContactsTest()
	{
		hp.clickContatcs();
		cp.selectContactsByName("Gojo");
		cp.selectContactsByName("Madara");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	@Description("To Verify New Contacts Created By Getting Data From TestData Excel File")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		hp.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		cp.createNewContact(title, firstName, lastName, company);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
