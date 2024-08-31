package com.qa.Webshop.Page;

import java.util.Properties;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegisterPage {
	
	
	private Page page;
	
	private String Regbutn="[class=\'ico-register\']";
	private String genderbtn="[name=\'Gender\']";
	private String firstname="[id='FirstName']";
	private String lastname="//*[@id='LastName']";
	private String email="//*[@id=\"Email\"]";
	private String pass="[id=\'Password\']";
	private String conpasss="[id='ConfirmPassword']";
	private String reg2btn="//input[@id=\"register-button\"]";
	
	
	
	private String regScText="//div[@class=\'result\']";
	
	public RegisterPage(Page page)
	{
		this.page=page;
	}

	public String registrationmessageString() 
	{
	   return page.innerText(regScText);
	}
	
	public String getUrl() 
	{
		return page.url();
	}
	public String getTittle() 
	{
		return page.title();
	}
	
	public Boolean registerPageAction(String randomemail, Properties pro) throws InterruptedException 
	{
		
		page.click(Regbutn);
		
		page.click(genderbtn);
	boolean	gederbtnCheck=page.isChecked(genderbtn);
		
		page.fill(firstname, pro.getProperty("fn"));
	
		page.fill(lastname,pro.getProperty("ln"));
		page.fill(email, randomemail);
	
		page.fill(pass, pro.getProperty("pass"));
		page.fill(conpasss,pro.getProperty("conpass"));
		page.click(reg2btn);
		 
		return gederbtnCheck;
		
	}

}
