package com.qa.Webshop.baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.playwright.Page;
import com.qa.Webshop.Factory.Factory;
import com.qa.Webshop.Page.BookPage;
import com.qa.Webshop.Page.CheckoutPage;
import com.qa.Webshop.Page.ComputerPage;
import com.qa.Webshop.Page.ElectronicPage;
import com.qa.Webshop.Page.JweleryPage;
import com.qa.Webshop.Page.RegisterPage;
import com.qa.Webshop.Page.logout;
import com.qa.Webshop.commonUtilities.commonUtilities;

public class baseTest {





	protected Factory pf;
	protected Page page;
	protected RegisterPage rgpage;
	protected BookPage bookpage;
	protected CheckoutPage chekoutpg;
	protected ComputerPage computerPage;

	protected FileInputStream fs;
	protected  Properties pro;
	protected commonUtilities comutil;
	protected ElectronicPage electPage;
	protected JweleryPage jwelpage;
	protected Logger log;
	protected Appender app;
	protected logout logout;


	protected	ExtentSparkReporter htmlReporter;
	protected	ExtentReports reports;
	protected	ExtentTest test;

	@BeforeTest
	public void setUp() throws IOException 
	{
		log=LogManager.getLogger(this.getClass());
		pf=new Factory();


		log.info("Starting Browser....");
		page=pf.initialiseBrows("firefox");
		rgpage=new RegisterPage(page);
		bookpage=new BookPage(page);
		chekoutpg=new CheckoutPage(page);
		fs=new FileInputStream("src/test/resources/reg.properties");
		pro=new Properties();
		pro.load(fs);

		logout=new logout(page);

		comutil=new commonUtilities();
		computerPage=new ComputerPage(page);
		electPage=new ElectronicPage(page);
		jwelpage=new JweleryPage(page);

		page.setDefaultNavigationTimeout(60000);


		htmlReporter=new ExtentSparkReporter("ExtendReport.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);


		//Add Test Evs Details
		reports.setSystemInfo("Machine Name", "Test_Laptop1");
		reports.setSystemInfo("Os", "Windows");
		reports.setSystemInfo("User", "Rosh");
		reports.setSystemInfo("Browser", "Chrome");

		//Configuration to design look and feel of report
		htmlReporter.config().setDocumentTitle("DemoWebShopCompleteAutomationCode");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE,MMMM,dd,yyyy,hh:mm a '('zzz')'");

		test=reports.createTest("Setting up object Complete");
	}


	@AfterMethod
	public void getTestResult(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Fail",ExtentColor.RED));
		}
		else if(result.getStatus()==ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASS",ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP) 
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIP",ExtentColor.YELLOW));
		}

	}


	@AfterTest
	public void flushReport() 
	{
		reports.flush();
	}


	@AfterSuite
	public void TearDown() throws InterruptedException 
	{

		Thread.sleep(30000);
		page.close();
		System.out.println("TearDownSuccessful");

	}

}
