package com.freecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.freecrm.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prp;

	public TestBase()
	{
		try
		{		
			prp = new Properties();
			prp.load(new FileInputStream("/home/arcgate/Demon/Selenium/FreeCRM_HybridFramework/src/main/java/com/freecrm/config/config.properties"));
		}
		catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void initialization()
	{
		WebDriverManager.chromedriver().setup();
		
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--headless");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		
		driver.get(prp.getProperty("url"));
	}
}
