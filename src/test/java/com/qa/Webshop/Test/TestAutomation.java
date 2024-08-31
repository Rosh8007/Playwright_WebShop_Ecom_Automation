package com.qa.Webshop.Test;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Webshop.Appconstant.Appconstant;
import com.qa.Webshop.baseTest.baseTest;

public class TestAutomation extends baseTest {


   String email;

  

	@Test(priority = 1)
	public void regstrationPage() throws InterruptedException 
	{
		log.info("=====================regstrationPage=================================");
        reports.createTest("Registration page Testing Started");
        
		email = "Rosh" + System.currentTimeMillis() + "@gmail.com";

		Boolean attributes=rgpage.registerPageAction(email,pro);

		System.out.println("Is Gender btn Visible :"+attributes);

		System.out.println(rgpage.registrationmessageString());

		System.out.println("Current page Url :"+rgpage.getUrl());
		System.out.println("current page :"+rgpage.getTittle());

		try {
			log.info("Asserting Registration page URL....");
			Assert.assertEquals(rgpage.getUrl(), pro.getProperty("regUrl"));
			log.info("Url matches with Url provided....");
			log.info("Asserting Page Tittle....");
			Assert.assertEquals(rgpage.getTittle(), pro.getProperty("regTittle"));
			log.info("Registration Page Tittle Assetion  Successful....");
			log.info("Asserting Page Tittle....");
			Assert.assertEquals(rgpage.registrationmessageString(), Appconstant.REGISTRATION_MESSAGE);
			log.info("Registration Message Assertion Succesful....");

		} catch (Exception e)
		{
			e.printStackTrace();
			log.warn("Assertion Failure detected in Registration Page");
		}
		System.out.println(email);

	}

//	@Test(priority = 2)
//	public void loginPage() 
//	{
//		log.info("Checkout on logout Function....");
//		System.out.println("=============Clicking on logout Function....=================");
//
//		logout.setUpLogOut();
//		List<Object>	lout=logout.logoutActions(email, pro);
//
//		System.out.println("Is Email Textbox visible:"+lout.get(0));
//		System.out.println("Is password Textbox visible:"+lout.get(1));
//		
//		Assert.assertEquals(lout.get(0),true);
//		Assert.assertEquals(lout.get(1), false);
//
//
//
//	}

	@Test(priority = 3)
	public void buyingBookTest()  
	{
		System.out.println("=====================buyingBookTest=================================");

		reports.createTest("Buying Book Testing Started");

		bookpage.BuyingBookOptions();

		Object[]   prodinfo=bookpage.getProductInfo();
		System.out.println("Book Name"+prodinfo[0]);
		System.out.println("Book Description"+prodinfo[1]);
		System.out.println(prodinfo[2]);

		Assert.assertEquals(prodinfo[0], "Computing and Internet");
		Assert.assertEquals(prodinfo[1], "More Than 100 tips about computing and internet.");
		Assert.assertEquals(prodinfo[2], "Availability: In stock");

		System.out.println("Current page Url :"+bookpage.getUrl());
		System.out.println("current page :"+bookpage.getTittle());

		try {
			log.info("Asserting Book buying page URL....");
			Assert.assertEquals(bookpage.getUrl(), pro.getProperty("bookpageUrl"));
			log.info("Book page Url Assertion Successful....");
			log.info("Asseting Book buying page Tittle");
			Assert.assertEquals(bookpage.getTittle(), pro.getProperty("bookpageTittle"));
			log.info("BookPage Tittle is Successfully Asserted....");

		} catch (AssertionError e) {
			e.printStackTrace();
			log.warn("Assertion Failure detected buying book Test");
		}


	}

	@Test(priority = 4)
	public void buyingcomputer() 
	{
		System.out.println("=====================buyingcomputer=================================");

		reports.createTest("buying Computer Testing Started");
		computerPage.gotoBuyingComputer();


		System.out.println("Current page Url :"+computerPage.getUrl());
		System.out.println("current page :"+computerPage.getTittle());

		Object[] comp=computerPage.compAttributes();

		System.out.println("Computer Attributes:"+comp[0]);
		System.out.println("Computer discription:"+comp[1]);
		System.out.println("Computer image:"+comp[2]);

		try {

			log.info("Asserting Computer discription Attributes....");
			Assert.assertEquals(comp[1], pro.getProperty("compDisc"));
			log.info("Computer Computer discription is Succesfully Asserted....");
			log.info("Asserting Computer image Attributes....");
			Assert.assertEquals(comp[2],true);
			log.info("Computer Computer image is Shuccesfully Asserted....");
			log.info("Asserting Computer page URL ....");
			Assert.assertEquals(computerPage.getUrl(), pro.getProperty("comUrl"));
			log.info("Computer Url is Successfully Asserted....");
			log.info("Asserting Computer page Tittle....");
			Assert.assertEquals(computerPage.getTittle(),pro.getProperty("comTittle"));
			log.info("Computer Page Tittle is Succesfully Asserted....");
		} catch (AssertionError e) 
		{
			e.printStackTrace();
			log.warn("Assertion failure detected in buying Electronics Method....");	
		}



		computerPage.compbuyAction();

	}
	@Test(priority = 5)
	public void   buyingElectronic() 
	{
		System.out.println("=====================buyingElectronic=================================");

		electPage.ElectronicsActions();
		System.out.println("Current page Url :"+electPage.getUrl());
		System.out.println("current page :"+electPage.getTittle());
		System.out.println("is Email Friennd button Visible:"+electPage.emailFrndButton());
		System.out.println("is Comprair Product button visible:"+electPage.compareProdButton());

		try {
			log.info("Asserting Email Friends button....");
			Assert.assertTrue(electPage.emailFrndButton());
			log.info("Email Friend button is present on page is visibe....");
			log.info("Asserting Compare product button....");
			Assert.assertTrue(electPage.compareProdButton());
			log.info("Compare Product button is Asserted successfully....");
			log.info("Asserting Electronic page url....");
			Assert.assertEquals(electPage.getUrl(), pro.getProperty("elecUrl"));
			log.info("electronic page Url to actual URL Asserted succesfully....");
			log.info("Asserting page Tittle....");
			Assert.assertEquals(electPage.getTittle(), pro.getProperty("elecTittle"));
			log.info("Actual tittle to expected tittle is asserted successfully....");
		} 
		catch (AssertionError e) 
		{
			e.printStackTrace();
			log.warn("Assertion failure detected in buying Electronics Method....");
		}


		System.out.println("Device Name:"+electPage.getDeviceName());
		System.out.println("Computer Price :"+electPage.getPrices());


	}
	@Test(priority = 6)
	public void buyingJwelery() throws InterruptedException
	{
		System.out.println("========================BuyingJwelery===================");

         reports.createTest("Buying Electronics Testing Started");
		Thread.sleep(2000);
		jwelpage.gotoJwelery();

		System.out.println("Product Prices :"+jwelpage.getProductPrices());

		System.out.println("Product Name :"+jwelpage.getProductName());

		System.out.println("Current page Url :"+jwelpage.getUrl());
		System.out.println("current page :"+jwelpage.getTittle());

		try 
		{
			log.info("Asserting Jwelery product name....");
			Assert.assertEquals(jwelpage.getProductName(),pro.getProperty("jweleryName"));
			log.info("Jwelery product Name matches Assertion is completed succesfully....");
			log.info("Asserting jwelery page Tittle....");
			Assert.assertEquals(jwelpage.getTittle(), pro.getProperty("jwelerypageTittle"));
			log.info("Jwelery product Tittle matches is completed Successfully....");
			log.info("Asserting jwelery page url....");
			Assert.assertEquals(jwelpage.getUrl(), pro.getProperty("jwelwryUrl"));
			log.info("Jwelery Url matches actual URL Successfully....");
		} catch (AssertionError e) 
		{
			e.printStackTrace();
			log.warn("Assertion failure detected in buying Jwelery Method....");
		}

		jwelpage.jweleryActions();


	}

	@Test(priority = 7)
	public void checkoutPageTest() throws IOException 
	{
		
		reports.createTest("Checkout page Testing Started");
		System.out.println("=====================Checkout Started======================");
		chekoutpg.CheckoutOptions();

		List<Object>confrMessage=chekoutpg.finalconfirmation();
		System.out.println(confrMessage.get(1));
		System.out.println(confrMessage.get(0));
		System.out.println(confrMessage.get(2));

		System.out.println("====================CheckoutPage Successful===============");


	}

}





