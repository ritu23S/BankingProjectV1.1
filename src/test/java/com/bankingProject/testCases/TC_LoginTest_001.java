package com.bankingProject.testCases;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankingProject.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() {
		
		driver.get(baseURL);
		
		logger.info("URL is openned");
		
		// Login Page
				LoginPage lp = PageFactory.initElements(driver,LoginPage.class);
			
				lp.setUserName(username);
				logger.info("UName Entered");
				
				lp.setPassword(password);
				logger.info("Pwd is entered");
				
				
				lp.clickSubmit();
				logger.info("login button is submitted");
				
				String title = driver.getTitle();
				System.out.println(title);
		
		if(driver.getTitle().equals("GTPL Bank HomePage"))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertTrue(false);
		}
		
	}
	
}
