package com.bankingProject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bankingProject.pageObjects.LoginPage;
import com.bankingProject.utilities.XLUtils;

public class TC_LoginDDT002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(pwd);
		logger.info("user name is provided");
		lp.setPassword(pwd);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("logged failed");
		}else {
			
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
			
	}
	
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String [] [] getData() throws IOException{
		String path="C:\\Users\\vivec\\eclipse-workspace\\BankingProjectV1\\src\\test\\java\\com\\bankingProject\\testData\\LoginData.xlsx";
		
		int rownum =XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
	
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);
				
			}
			
			
		}
		return logindata;
	}

}
