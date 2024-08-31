package com.qa.Webshop.Page;

import com.microsoft.playwright.Page;
import com.qa.Webshop.Appconstant.Appconstant;

public class ComputerPage {

	Page page;

	private String computer="text='Computers'";
	private String desktop="//a[@href=\"/desktops\"]";
	private String selectcomp="text='Build your own expensive computer'";
	private String ram="#product_attribute_74_6_27_85";
	private String processor="[id=\"product_attribute_74_5_26_82\"]";
	private String Hdd="[id=\'product_attribute_74_3_28_87\']";
	private String contityCommand="//input[@class='qty-input']";
	private String addtocart="input#add-to-cart-button-74";
	private String discription=".full-description";
	private String productimage="#main-product-img-74";

	public Object[] compAttributes() 
	{
		page.waitForSelector("//div[@class=\"attributes\"]");
		page.waitForSelector(productimage);
		return new Object[] 
				{
						
						page.locator("//div[@class=\"attributes\"]")
						.innerText(),
						page.innerText(discription),
						
						page.isVisible(productimage)
				};
	}

	public ComputerPage(Page page) 
	{
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
	public void gotoBuyingComputer() 
	{
		page.click(computer);
		page.click(desktop);
		page.waitForSelector(selectcomp);
		page.click(selectcomp);

	}
	public void compbuyAction() 
	{

		page.click(ram);
		page.click(processor);
		page.click(Hdd);
		page.fill(contityCommand,Appconstant.Computer_Quantity);
		page.click(addtocart);
	}


}
