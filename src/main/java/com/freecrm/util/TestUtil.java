package com.freecrm.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.*;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.freecrm.base.TestBase;

public class TestUtil extends TestBase
{
	public static long page_load_timeout=30;
	
	public static String TESTDATA_SHEET_PATH = "/home/arcgate/Demon/Selenium/FreeCRM_HybridFramework/src/main/java/com/freecrm/testdata/FreeCrmTestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName) 
	{
		FileInputStream file = null;
		try 
		{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			book = WorkbookFactory.create(file);
		} 
		catch (InvalidFormatException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
}
