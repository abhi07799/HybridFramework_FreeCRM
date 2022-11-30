package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

import io.qameta.allure.Step;

public class HomePage extends TestBase
{
	@FindBy(xpath="//td[1][@class=\"headertext\" ]")
	WebElement userNameLabel;
		
	@FindBy(xpath="//a[@title=\"Calendar\" ]")
	WebElement calendarLink;
	
	@FindBy(xpath="//a[@title=\"Companies\" ]")
	WebElement companyLink;
	
	@FindBy(xpath="//a[@title=\"Contacts\" ]")
	WebElement contactLink;
	
	@FindBy(xpath="//table[@class=\"crmcalendar\"]")
	WebElement calendarPage;

	@FindBy(xpath="//td[@class=\"datacardtitle\"]")
	WebElement companiesPage;
	
//	@FindBy(xpath="//a[@title=\"New Contact\"]")
//	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	//Initializing Elements
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	@Step("To Return Home Page Title")
	public String homePageTitle()
	{
		return driver.getTitle();
	}
	
	@Step("To Check User Name Displayed")
	public boolean userNameDisplayed()
	{
		return userNameLabel.isDisplayed();
	}
	
	@Step("To Check Calendar Page Displayed")
	public boolean clickCalendar()
	{
		calendarLink.click();
		return calendarPage.isDisplayed();
		
	}
	
	@Step("To Check Companies Page Displayed")
	public boolean cilckCompanies()
	{
		companyLink.click();
		return companiesPage.isDisplayed();
	}
	
	@Step("To Click On Contacts Page")
	public void clickContatcs()
	{
		contactLink.click();
	}
	
	@Step("To Check Contacts Page Displayed")
	public boolean clickContacts()
	{
		return contactLink.isDisplayed();
	}
	
	@Step("To Initialize Contacts Page And Getting An Object")
	public ContactsPage initializeContactsObject()
	{
//		contactLink.click();
		
		return new ContactsPage();
	}
	
	@Step("To Click On New Contact Button To Create A New Contact")
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
		
	}
}
