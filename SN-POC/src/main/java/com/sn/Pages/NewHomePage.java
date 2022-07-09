package com.sn.Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sn.Commons.TestBase;

import junit.framework.Assert;
//import com.sn.Testcases.CanHelp;

public class NewHomePage extends TestBase

{

	TestBase t = new TestBase();

	@FindBy(xpath="//h2[normalize-space()='Request Something']")
	WebElement RequestSomething;


	@FindBy(id="e15706fc0a0a0aa7007fc21e1ab70c2f")

	WebElement HelpYou;

	@FindBy(id="sc_cat_item_3f1dd0320a0a0b99000a53f7604a2ef9")
	WebElement CreatIncident;


	@FindBy(xpath="//span[contains(@class,'select2-arrow')]//b")
	WebElement Urgency;

	//@FindBy(id="select2-result-label-13")     //Try all locator but no one work so at last used Absulate Path
	@FindBy(xpath="/html/body/div[3]/ul/li[4]/div")
	WebElement LowButton;


	@FindBy(xpath="//textarea[@id=\"sp_formfield_comments\"]")
	WebElement Description1;
	@FindBy(how=How.XPATH,using="//span[text()='Some fields are incomplete: Please describe your issue below']")
    WebElement errmsg;

	@FindBy(xpath="//button[@id=\"submit-btn\"]")
	WebElement Button;


	@FindBy(xpath="//div[@id=\"data.number.name\"]")
	WebElement IncidentNo;

	@FindBy(xpath ="/html/body/div[1]/div[1]/span/div/div[1]/div/span/div/div/input")
	WebElement SearchButton;


	public NewHomePage()
	{
		PageFactory.initElements(t.driver, this);
	}

	public String VerifyTitle()
	{
		return t.driver.getTitle();

	}

	//clicking on RequestSomething
	public CanHelp  ClickOnRequestSomething(String Description) throws InterruptedException
	{
		System.out.println("Click on RequestSomething");

		Set<String>handles=driver.getWindowHandles();
		System.out.println(handles);
		Iterator<String>it01=handles.iterator();
		it01.next();
		String wn3= it01.next();
		driver.switchTo().window(wn3);
		String title=driver.getTitle();

		System.out.println("*****Title of New Home page After Switching window  ****** " +title);

		WebDriverWait wait = new WebDriverWait(driver,20);//used Explicit wait
		wait.until(ExpectedConditions.visibilityOf(RequestSomething));


		RequestSomething.click();
		System.out.println("Request Something link clicked");


		HelpYou.click();
		System.out.println("Clicked on HelpYou");
		WebDriverWait wait1 = new WebDriverWait(driver,20);//used explicit wait
		wait1.until(ExpectedConditions.visibilityOf(CreatIncident));

		CreatIncident.click();
		System.out.println("Clicked on Create Incident");

		Actions mouse = new Actions(driver);
		mouse.moveToElement(Urgency).click().build().perform();
		mouse.moveToElement(LowButton).click().build().perform();

if(Description.isBlank())
{
	Button.click();
	String str=errmsg.getText();
	System.out.println("Error messgae is :"+str);
	System.out.println("********Mandotory input of Description is not availble in Excel File Name is Data1 and sheet name is Describeissue *******");
	Assert.assertEquals(false, true);
	driver.quit();
}
else
	{
	Description1.sendKeys(Description);

	}

		Description1.sendKeys(Description);
		System.out.println("clicked on Description");
		WebDriverWait wait3 = new WebDriverWait(driver,10);
		wait3.until(ExpectedConditions.visibilityOf(Button));
		if(Button.isEnabled() && Button.isDisplayed())
		{
			Button.click();
			System.out.println("***************************************");
			System.out.println("Button is Enabled and Display on the screen ");

			System.out.println("***************************************");
		}
		else
		{
			System.out.println("Button is not Enabaled");
		}
		//System.out.println(" clicked on Button");

		String s=IncidentNo.getText();
		System.out.println(s);
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		System.out.println(tabs2);

//		Set<String>handles01=driver.getWindowHandles();
//		System.out.println(handles01);
//		Iterator<String>it02=handles01.iterator();
//		it02.next();
//
//		String windo3= it02.next();
//		driver.switchTo().window(windo3);
		driver.switchTo().frame(0);
		SearchButton.sendKeys(s);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();

		//verify End user Incident created or not
		String t = s;
		if ( driver.getPageSource().contains( t))
		{
			System.out.println("End user Incident Created Sussefully");

		} 
		else {
			System.out.println("End user Incident not created ");
		}


		return new CanHelp();

	}

}