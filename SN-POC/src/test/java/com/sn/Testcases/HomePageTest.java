package com.sn.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
//import com.sn.Pages.IncidentCreate;
import com.sn.Pages.LoginPage;
import com.sn.Pages.NewHomePage;



public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	NewHomePage newHomePage;


	@BeforeMethod
	public void setup() throws InterruptedException, IOException 
	{
		launch();
		loginpage = new LoginPage();
		driver.switchTo().frame(0);
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));

	}


	 @Test 
	public void verify() throws InterruptedException 
	{ 
		String title = homepage.VerifyTitle(); 
		String expected="ServiceNow";
		if(title.equalsIgnoreCase(expected))
		{
			System.out.println("Testcase passed");
		}
		else
		{		  System.out.println("Testcase failed");
		}

		System.out.println(title);
		//Assert.assertEquals(title, "ServiceNow Developers", "Title not matched"); 
	}

	@Test
	public void SearchIncident() throws InterruptedException
	{
		System.out.println("Executing SearchIncident test case");
		newHomePage = homepage.SearchIncident();
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
