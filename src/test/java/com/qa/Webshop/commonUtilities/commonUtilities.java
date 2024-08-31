package com.qa.Webshop.commonUtilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class commonUtilities {
	
	
	
	static XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	public static XSSFRow excelhere() throws IOException 
	{
		wb=new XSSFWorkbook("src/test/resources/Checkoutdata.xlsx");
		return wb.getSheet("Sheet1").getRow(0);
	}
	public static String companyName() throws IOException 
	{
		return  excelhere().getCell(0).getStringCellValue();
	}
	public static String countryName() throws IOException 
	{
		return  excelhere().getCell(1).getStringCellValue();
	}
	public static String stateName() throws IOException 
	{
		return  excelhere().getCell(2).getStringCellValue();
	}
	public static String cityName() throws IOException 
	{
		return  excelhere().getCell(3).getStringCellValue();
	}
	public static String add1Name() throws IOException 
	{
		return  excelhere().getCell(4).getStringCellValue();
	}
	public static String add2Name() throws IOException 
	{
		return  excelhere().getCell(5).getStringCellValue();
	}
	public static double zipName() throws IOException 
	{
		return  excelhere().getCell(6).getNumericCellValue();
	}
	public static double phoneName() throws IOException 
	{
		return  excelhere().getCell(7).getNumericCellValue();
	}
	public static double faxName() throws IOException 
	{
		return  excelhere().getCell(8).getNumericCellValue();
	}
	
	
}
