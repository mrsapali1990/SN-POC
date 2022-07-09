package com.sn.Testcases;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
import com.sn.Pages.LoginPage;
import com.sn.Pages.NewHomePage;
import com.sn.utilities.TestUtil;

public class NewHomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	NewHomePage newhomepage;
	CanHelp canhelp;
	String wbsheet = "Describeissue";


	@BeforeMethod
	public void setup() throws InterruptedException,IOException
	{
		launch();
		loginpage = new LoginPage();
		driver.switchTo().frame(0);
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		homepage = new HomePage();
		newhomepage=homepage.SearchIncident();
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData=TestUtil.getDataFromExcel(wbsheet);
		return testData.iterator();

	}
	

	 
	 @Test(dataProvider="getTestData")
	public void ClickOnRequestSomething(String Description) throws InterruptedException
	{
		System.out.println("Executing Request Something test case");
		newhomepage.ClickOnRequestSomething(Description);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}


}
