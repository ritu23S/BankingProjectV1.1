package com.bankingProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		
	
	}
	
	@FindBy(name="uid")
	private WebElement userName;

	@FindBy(name="password")
	private WebElement password;

	@FindBy(name="btnLogin")
	private WebElement button;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[10]/a")
	private WebElement logout;
	
	
	public void setUserName(String uname) {
		
		userName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		
		password.sendKeys(pwd);
		
	}
	
	public void clickSubmit() {
		
		button.click();
		
	}
	
	public void clickLogout() {
		
		logout.click();
		
	}
	
	
	
}
