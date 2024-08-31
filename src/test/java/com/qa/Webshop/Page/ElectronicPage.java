package com.qa.Webshop.Page;

import com.microsoft.playwright.Page;

public class ElectronicPage {


	Page page;

	private String searchbox="#small-searchterms";
	private String searchbtn="//input[@type='submit']";
	private String comcorder="text='High Definition 3D Camcorder'";
	private String devicename="[itemprop='name']";
	private String prices="//div[@class='prices']";

	private String emailafrnd="div.email-a-friend";
	private String compareproductbtn="[class=\'button-2 add-to-compare-list-button\']";

	public ElectronicPage(Page page) 
	{
		this.page=page;
	}
	public String getDeviceName() 
	{
		return page.innerText(devicename);
	}
	public String getPrices() 
	{
		return page.innerText(prices);	
	}
	public Boolean emailFrndButton() 
	{
		return page.locator(emailafrnd).isVisible();
	}
	public String getUrl() 
	{
		return page.url();
	}
	public String getTittle() 
	{
		return page.title();
		
	}
	public boolean compareProdButton() 
	{
		return page.locator(compareproductbtn).isEnabled();
	}
	public void ElectronicsActions() 
	{
		
		page.fill(searchbox,"Camcorder");
		page.click(searchbtn);
		page.click(comcorder);

	}

}
