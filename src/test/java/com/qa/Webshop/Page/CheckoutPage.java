package com.qa.Webshop.Page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.qa.Webshop.commonUtilities.commonUtilities;

public class CheckoutPage {


	private	Page page;

	private String company="#BillingNewAddress_Company";
	private String country="//select[@name='BillingNewAddress.CountryId']";
	private String state="//select[@id='BillingNewAddress_StateProvinceId']";
	private String city="//input[@id='BillingNewAddress_City']";
	private String addr1="//input[@id=\'BillingNewAddress_Address1\']";
	private String adr2="//input[@name='BillingNewAddress.Address2']";
	private String zipcode="[name=\'BillingNewAddress.ZipPostalCode\']";
	private String phoneNo= "text='Phone number:'";                //"[name=\"BillingNewAddress.PhoneNumber\']";//name="BillingNewAddress.PhoneNumber"
	private String faxNo="//input[@name='BillingNewAddress.FaxNumber']";
	private String continue1="[title=\"Continue\"]:nth-child(1)";
	private String continue2="[onclick='Shipping.save()']";
	private String continue3="[onclick=\'ShippingMethod.save()\']";
	private String continue4="[onclick=\"PaymentMethod.save()\"]";
	private String continue5="[onclick=\"PaymentInfo.save()\"]";
	private String finalOrderData="//table[@class=\"cart-total\"]//tr";
	private String continue6="[onclick=\"ConfirmOrder.save()\"]";
	
	

	public CheckoutPage(Page page) 
	{
		this.page=page;
	}

	 String Shippingdata = "";
	public void CheckoutOptions() throws IOException 
	{
		page.waitForLoadState();
		page.fill(company, commonUtilities.companyName());

		page.locator(country).selectOption(commonUtilities.countryName());
		page.locator(state).selectOption(commonUtilities.stateName());


		page.fill(city, commonUtilities.cityName());
		page.fill(addr1, commonUtilities.add1Name());
		page.fill(adr2, commonUtilities.add2Name());
		
		   double zip=commonUtilities.zipName();
		   
		   
		
		page.fill(zipcode,String.valueOf(zip) );
		page.fill(phoneNo, String.valueOf(commonUtilities.phoneName()));
		page.fill(faxNo,String.valueOf(commonUtilities.faxName()));
		page.click(continue1);
		page.click(continue2);
		page.click(continue3);
		page.click(continue4);
		page.click(continue5);
		
		
		 page.waitForSelector("//ul[@class='billing-info']//li");

        
        List<String> itemsText = page.locator("//ul[@class='billing-info']//li").allInnerTexts();
        for (String text : itemsText)
        {
            System.out.println(text);
        }
      
       
		 page.waitForSelector("//ul[@class=\"shipping-info\"]//li");
       List<String> shippingaddr = page.locator("//ul[@class=\"shipping-info\"]//li").allInnerTexts();
       for (String text : shippingaddr) 
       {
             Shippingdata+=text;
       }
	
    
	}
	
	public List<Object> finalconfirmation() 
	{
		
		
		page.click(continue6);
		page.waitForSelector("[class='title']");
		page.waitForSelector("[class='details']");


		List<Object>list=new ArrayList<>();
		list.add(page.locator("[class=\"title\"]").innerText());
		list.add(page.locator("[class=\"details\"]").innerText());
		list.add(Shippingdata);
		
		return list;
		
	}


}
