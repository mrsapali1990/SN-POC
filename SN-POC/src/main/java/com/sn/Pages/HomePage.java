package com.sn.Pages;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sn.Commons.TestBase;
import com.sn.utilities.ExcelUtilities;

public class HomePage extends TestBase
{
	TestBase t = new TestBase();

	@FindBy(id = "filter")
	WebElement TypeIncident;

	@FindBy(xpath = "//*[@id=\"087800c1c0a80164004e32c8a64a97c9\"]/div/div")
	WebElement ClickSearch;

	public HomePage()
	{
		PageFactory.initElements(t.driver, this);
	}

	public String VerifyTitle()
	{
		return t.driver.getTitle();

	}


	public NewHomePage SearchIncident() throws InterruptedException 
	{
//		Thread.sleep(15000);
//		String drpdwn = "document.querySelector(\"body > dps-app\").shadowRoot.querySelector(\"div > header > dps-navigation-header\").shadowRoot.querySelector(\"header > div > div.dps-navigation-header-utility > ul > li:nth-child(2) > dps-login\").shadowRoot.querySelector(\"div > button\")"+ ".click()";
//		((JavascriptExecutor)driver).executeScript(drpdwn);
//
//		//Clicking on start build
//		//Shadow-root element
//
//
//		Thread.sleep(10000);
//		String StartBuild = "document.querySelector(\"body > dps-app\").shadowRoot.querySelector(\"div > header > dps-navigation-header\").shadowRoot.querySelector(\"header > dps-navigation-header-dropdown > dps-navigation-login-management\").shadowRoot.querySelector(\"dps-navigation-header-dropdown-content > dps-navigation-section:nth-child(1) > dps-navigation-instance-management\").shadowRoot.querySelector(\"div > div:nth-child(2) > dps-content-stack:nth-child(5) > dps-button\").shadowRoot.querySelector(\"button\")" + ".click()";
//		((JavascriptExecutor)driver).executeScript(StartBuild);
		//Switch to new tab
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		System.out.println(tabs2);
		TypeIncident.sendKeys("Incident");

		ClickSearch.click();
		System.out.println("Clicked on Incident");
		WebDriverWait wait = new WebDriverWait(driver, 10);//explicit wait are used
	    wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		//Thread.sleep(5000);
		if(ClickSearch.isDisplayed())
		{
			System.out.println("Testcase passed and clicked on incident");
		}
		else
		{
			System.out.println("Not able to click on incident. Test case failed.");
		}


		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(p.getProperty("newurl"));

		return new NewHomePage ();

	}
}