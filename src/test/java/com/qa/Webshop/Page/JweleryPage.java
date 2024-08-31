package com.qa.Webshop.Page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.qa.Webshop.Appconstant.Appconstant;
import com.qa.Webshop.baseTest.baseTest;

public class JweleryPage {


	Page page;

	private String jwelary="text='Jewelry'";
	private String product="text='Black & White Diamond Heart'";
	private String productName="//div[@itemprop='description']//p";
	private String productPrice="//span[@class=\"price-value-14\"]";
	private String productQunt="#addtocart_14_EnteredQuantity";
	private String addToCart="#add-to-cart-button-14";
	private String shippingCart="//a[@href=\"/cart\"]";
	private String Tos="[id='termsofservice']";
	private String checkout="//button[@id='checkout']";

	public JweleryPage(Page page) {

		this.page=page;
	}
	public String getUrl() 
	{
		return page.url();
	}
	public String getTittle() 
	{
		return page.title();
	}
	public String getProductName() throws InterruptedException 
	{
		Thread.sleep(2000);	
		return page.locator(productName).innerText();
	}
	public String getProductPrices() 
	{
		
		//page.waitForSelector(productPrice);
		
		return page.locator(productPrice).textContent();
	}

	public void gotoJwelery() 
	{
		page.waitForLoadState(LoadState.LOAD);
		page.click(jwelary);
		page.click(product);

	}
	public void jweleryActions() 
	{
		page.waitForLoadState(LoadState.LOAD);

		page.fill(productQunt,Appconstant.Jwelery_Quantity);
		page.click(addToCart);
		page.click(shippingCart);
		page.click(Tos);
		page.click(checkout);
	}

}
