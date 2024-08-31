package com.qa.Webshop.Page;

import com.microsoft.playwright.Page;

public class BookPage {


	Page page;

	private String bookbtn="//a[@href='/books']";
	private String SelectBookbtn="//h2[@class=\"product-title\"]//a";

	private String addTocart="//input[@class=\"button-1 add-to-cart-button\"]";


	private String checkoutText="text=checkout";

	private String bookname="//h1[@itemprop='name']";
	private String discription="[class='short-description']";
	private String isinstock="[class='stock']";

	public BookPage(Page page) 
	{
		this.page=page;
	}
	
	public Object[] getProductInfo() 
	{
		return new  Object[] 
		{
				page.innerText(bookname),
				page.innerText(discription),
				page.innerText(isinstock)
				
		};
	}


	

	public  String checkout() 
	{
		return page.innerText(checkoutText);
	}
	public String getUrl() 
	{
		return page.url();
	}
	public String getTittle() 
	{
		return page.title();
	}
	public void BuyingBookOptions() 
	{
		page.click(bookbtn);
		page.click(SelectBookbtn);
		page.click(addTocart);

		//Thread.sleep(3000);
		//page.click(checkout);
	}


}
