package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;

public class LoginIntoLinkedin extends TestBase{
	
	LoginPage loginPageObj;
	HomePage homePageObj;
	
	@DataProvider(name = "linkedin URL data")
	public Object[][] linkedinURLData() throws IOException {

		ExcelReader excelReaderObj = new ExcelReader();

		return excelReaderObj.getExcelData(0, 1, 1);

	}
	
	@Test(priority = 0, dataProvider = "linkedin URL data")
	public void openLinkedinLoginPage (String linkedinURL) {
		
		driver.get(linkedinURL);
		
		String expectedURL = linkedinURL;
		String currentURL = driver.getCurrentUrl();
		
		Assert.assertEquals(currentURL, expectedURL);
	}
	
	@DataProvider(name = "linkedin login data")
	public Object[][] linkedinRegistrationData() throws IOException {

		ExcelReader excelReaderObj = new ExcelReader();

		return excelReaderObj.getExcelData(1, 1, 2);

	}
	
	@Test(priority = 1, dataProvider = "linkedin login data", dependsOnMethods = "openLinkedinLoginPage")
	public void loginIntoLinkedin (String email, String password) throws InterruptedException {
		
		loginPageObj = new LoginPage(driver);
		loginPageObj.loginIntoLinkedin(email, password);
		Thread.sleep(3000);
		
		String expectedURL = "https://www.linkedin.com/feed/";
		String currentURL = driver.getCurrentUrl();
		
		Assert.assertEquals(currentURL, expectedURL);
	}
		

}
