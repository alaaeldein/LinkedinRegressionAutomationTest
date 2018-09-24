package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import data.ExcelReader;
import pages.LoginPage;
import pages.RegistrationPage;

public class SuccessLinkedinRegistration extends TestBase{
	
	RegistrationPage registrationPageObj;
	LoginPage loginPageObj;
	
	
	@DataProvider(name = "linkedin URL data")
	public Object[][] linkedinURLData() throws IOException {

		ExcelReader excelReaderObj = new ExcelReader();

		return excelReaderObj.getExcelData(0, 1, 1);

	}
	
	@Test(priority = 0, dataProvider = "linkedin URL data")
	public void openLinkedinSignupPage (String linkedinURL) {
		
		driver.get(linkedinURL);
		
		loginPageObj = new LoginPage(driver);
		loginPageObj.openLinkedinSignupPage();
		
		String expectedURL = "https://www.linkedin.com/start/join?trk=uno-reg-guest-home-join";
		String currentURL = driver.getCurrentUrl();
		
		Assert.assertEquals(currentURL, expectedURL);
		
	}
	
	@DataProvider(name = "linkedin registration data")
	public Object[][] linkedinRegistrationData() throws IOException {

		ExcelReader excelReaderObj = new ExcelReader();

		return excelReaderObj.getExcelData(1, 1, 4);

	}
	
	@Test(priority = 1, dataProvider = "linkedin registration data", dependsOnMethods = "openLinkedinSignupPage")
	public void successLinkedinRegister (String firstName, String lastName, String email, String password)
			throws InterruptedException
			{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		registrationPageObj = new RegistrationPage(driver);
		registrationPageObj.registerNewUserInLinkedin(firstName, lastName, email, password);
		
	}
	

}
