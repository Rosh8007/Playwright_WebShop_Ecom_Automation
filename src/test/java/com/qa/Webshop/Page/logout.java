package com.qa.Webshop.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.microsoft.playwright.Page;
import com.qa.Webshop.commonUtilities.commonUtilities;

public class logout {

	Page page;
	private String logOut=".ico-logout";
	private String login=".ico-login";
	private String emaillocator="[id='Email']";
	private String passWord="#Password";
	private String Finallogin="[value='Log in']";




	public logout(Page page) 
	{
		this.page=page;	
	}


	public void setUpLogOut() 
	{


	}
	public List<Object> logoutActions(String email,Properties pro) 
	{
		page.click(logOut);	
		page.click(login);
		System.out.println(email);
		page.locator("#Email").fill("Rosh1704958843051@gmail.com");

		page.fill(passWord,pro.getProperty("pass"));

		List<Object>data=new ArrayList<Object>();
		data.add(page.locator("#Email").isVisible());
		data.add(page.locator(passWord).isVisible());
		data.add(page.locator(emaillocator).isEnabled());


		page.click(Finallogin);

		return data;
	}
}
