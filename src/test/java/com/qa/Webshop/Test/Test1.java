package com.qa.Webshop.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test1 {

	public static void main(String[] args) {
		
     	Playwright	playwright=Playwright.create();
     	Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	
	   Page   page= browser.newContext().newPage();
	   page.navigate("https://demowebshop.tricentis.com/login");
	   
	   
	
	
	}
}
