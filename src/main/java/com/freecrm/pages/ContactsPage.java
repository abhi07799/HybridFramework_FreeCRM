package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.base.TestBase;

import io.qameta.allure.Step;

public class ContactsPage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	//Initializing
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	@Step("To Verify Contacts Label")
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	@Step("To Verify Contacts Name Selected")
	public void selectContactsByName(String name)
	{
//		driver.findElement(By.xpath("\"//a[text()='\"+name+\"']//parent::td[@class='datalistrow']\"\n"
//				+ "				+ \"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']\""));
		
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='datalistrow']/preceding-sibling::td[@class='datalistrow']"));
	}
	
	@Step("To Create New Contacts")
	public void createNewContact(String title, String ftName, String ltName, String comp)
	{
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();		
	}
}
