package com.qa.Webshop.Factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Factory
{
	
	Playwright playwright;
	Browser browser;
	BrowserContext brcontext;
	


	public Page initialiseBrows(String brws) 
	{
		 playwright = Playwright.create();
		 
		 
		System.out.println(brws);

		switch (brws.toLowerCase()) 
		{

		case "chromium":
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "chrome":
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setSlowMo(100));
			break;

		case "firefox":
			browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		default:
			break;
		}
		brcontext=browser.newContext();
		Page page=brcontext.newPage();
		page.navigate("https://demowebshop.tricentis.com");
		
		page.setDefaultTimeout(60000);
		return page;

	}


}
