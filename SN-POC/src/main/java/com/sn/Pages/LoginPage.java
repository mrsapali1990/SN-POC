package com.sn.Pages;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sn.Commons.TestBase;

public class LoginPage extends TestBase {

	TestBase t = new TestBase();
	
//	@FindBy(id = "username")
//	WebElement uname;
//	
//	@FindBy(id = "usernameSubmitButton")
//	WebElement NextBtn;
//	
//	@FindBy(id = "password")
//	WebElement password;
//	
//	@FindBy(id = "submitButton")
//	WebElement Loginbtn;
//	
//	@FindBy(id = "errorPlaceholder")
//	WebElement Errormsg1;
	
	
	@FindBy(xpath="//span[@class='dp-invalid-login-msg']")
	WebElement Errormsg1;
	
	@FindBy(xpath="//input[@id='user_name']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement password;
			
	@FindBy(xpath="//button[@id='sysverb_login']")
	WebElement loginbtn;
	
	public LoginPage()
	{
		PageFactory.initElements(t.driver, this);
	}
	
	
	public HomePage LoginData(String un, String pass) throws InterruptedException
	{
		
		if(username.isDisplayed())
		{
		System.out.println("UserName Field Displayed");
		username.sendKeys(un);
		}
		else
		{
		System.out.println("UserName Field Not Displayed");
		}
		//uname.sendKeys(un);
		System.out.println("UserName is  :" +un);
		System.out.println("Entered user name");
		System.out.println("-------------------------------------------------------------");
		//uname.sendKeys(un);
		//System.out.println(un);
		//boolean NextBtn_field =NextBtn.isDisplayed();
		//System.out.println("is NextBtn_field displayed  :"+  NextBtn_field);
//		if(NextBtn.isDisplayed() && NextBtn.isEnabled())
//		{
//		System.out.println("NExtButton Displayed And Enabled on login Page");
//		NextBtn.click();
//		}
//		else
//		{
//		System.out.println("NExtButton Not Displayed And NotEnabled on login Page");
//		}
		//NextBtn.click();

		//System.out.println("Clicked On next Button");
		System.out.println("-------------------------------------------------------------");
		//boolean passText =uname.isDisplayed();
		//System.out.println("is Password_TextField displayed  :"+  passText);
		if(password.isEnabled())
		{
		System.out.println("Password Field Enabled");
		password.sendKeys(pass);
		}
		else
		{
		System.out.println("Password Field Not Enabled");
		}
		//password.sendKeys(pass);
		System.out.println("Password is  :" +pass);
		System.out.println("Password Entered");
		//System.out.println(pass);
		System.out.println("-------------------------------------------------------------");
		//boolean Loginbtn_field =NextBtn.isEnabled();
		//System.out.println("is NextBtn_field displayed  :"+  Loginbtn_field);
		if(loginbtn.isEnabled() && loginbtn.isDisplayed())
		{
		System.out.println("LoginButton is Enabled and displayed ");
		loginbtn.click();
		}
		else
		{
		System.out.println("LoginButton is not Enabled not displayed");
		}

		//Loginbtn.click();
		System.out.println("Clicked On Login Button");
		System.out.println("-------------------------------------------------------------");
		//WebDriverWait wait = new WebDriverWait(driver,30);
		    //until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='list_action list_top_title']")));
		//String actualUrl="https://developer.servicenow.com/dev.do#!/home?wu=true";
		String expectedUrl= driver.getCurrentUrl();
		//Assert.assertEquals(expectedUrl,actualUrl);
		System.out.println("entered home page & title is :" + expectedUrl);
		//System.out.println("Test Case Passed and Go to thr HomePage\n");
		return new HomePage();
		}
		
	
	
//	public String Invalidlogin(String un, String pass)
//	{
//		
//			uname.sendKeys(un);
//			System.out.println(un);
//			NextBtn.click();
//			password.sendKeys(pass);
//			System.out.println(pass);
//			loginbtn.click();
//			WebDriverWait wait = new WebDriverWait(driver, 5);
//			wait.until(ExpectedConditions.visibilityOf(Errormsg1));
//			
//			String errormsg1 = Errormsg1.getText(); 
//			System.out.println("Error message is:" +errormsg1);
//			String expectederrormsg = "?Your username or password is invalid. Please try again or reset your password. If on mobile, please reset from your desktop device.";
//			
//			Assert.assertEquals(errormsg1, expectederrormsg, "Testcase passed");
//			return errormsg1;
//		
//		
//	}
//	
		
	public String verifyLogin()
	{
		return t.driver.getTitle();
		
	}

	

}
