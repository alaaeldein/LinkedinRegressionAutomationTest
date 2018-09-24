package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.ForgetPasswordPage;
import pages.Gmail;
import pages.HomePage;
import pages.LoginPage;
import pages.NewPasswordPage;

public class ForgetPassword extends TestBase {

	ForgetPasswordPage forgetPasswordObj;
	Gmail gmailObj;
	NewPasswordPage newPasswordObj;
	LoginPage loginPageObj;
	HomePage homePageObj;

	
	@Test(priority = 0)
	public void clickFogetPassword() {

		homePageObj = new HomePage(driver);
		homePageObj.performSignout();
		
		loginPageObj = new LoginPage(driver);
		loginPageObj.openForgotPasswordPage();

		String expectedURL = "https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password";
		String currentURL = driver.getCurrentUrl();

		Assert.assertEquals(currentURL, expectedURL);
	}

	@DataProvider(name = "forget password data")
	public Object[][] forgetPasswordData() throws IOException {

		ExcelReader excelReaderObj = new ExcelReader();

		return excelReaderObj.getExcelData(2, 1, 7);

	}

	@Test(priority = 1, dataProvider = "forget password data", dependsOnMethods = "clickFogetPassword")
	public void performForgetPassword(String email, String googleMailURL, String googleEmail, String googlePassword,
			String googleMailURLinHtml, String newPassword, String confirmNewPassword)
			throws AWTException, InterruptedException {

		forgetPasswordObj = new ForgetPasswordPage(driver);
		gmailObj = new Gmail(driver);
		newPasswordObj = new NewPasswordPage(driver);

		forgetPasswordObj.forgetPassword(email);

		// open new tab
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_T);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_T);

		// wait to winHandles value increases. Without it will result in random
		// nullPointerException at this point.
		Thread.sleep(100);

		// get fresh winHandles to ArrayList
		ArrayList<String> winHandles = new ArrayList<String>(driver.getWindowHandles());

		// select tab by index
		driver.switchTo().window(winHandles.get(1));

		driver.get(googleMailURL);

		gmailObj.loginIntoGmail(googleEmail, googlePassword);

		driver.get(googleMailURLinHtml);

		gmailObj.openEnterNewPasswordPage();
		Thread.sleep(6000);

		driver.close();

		// wait to winHandles value increases. Without it will result in random
		// nullPointerException at this point.
		Thread.sleep(100);

		// get fresh winHandles to ArrayList
		ArrayList<String> winHandles1 = new ArrayList<String>(driver.getWindowHandles());

		// select tab by index
		driver.switchTo().window(winHandles1.get(1));

		newPasswordObj.insertNewPassword(newPassword, confirmNewPassword);

		String expecedURL = "https://www.linkedin.com/checkpoint/rp/password-reset-submit";
		String currentURL = driver.getCurrentUrl();

		Assert.assertEquals(currentURL, expecedURL);

	}

	@DataProvider(name = "login using new password data")
	public Object[][] loginUsingNewPasswordData() throws IOException {

		ExcelReader excelReaderObj = new ExcelReader();

		return excelReaderObj.getExcelData(3, 1, 2);

	}

	@Test(priority = 2, dataProvider = "login using new password data", dependsOnMethods = "performForgetPassword")
	public void loginIntoLinkedinUsingNewPassword(String email, String password) {

		newPasswordObj = new NewPasswordPage(driver);
		newPasswordObj.openLinkedinHomePage();
		
		homePageObj = new HomePage(driver);
		homePageObj.performSignout();
		
		loginPageObj = new LoginPage(driver);
		loginPageObj.loginIntoLinkedin(email, password);

		String expectedURL = "https://www.linkedin.com/feed/";
		String currentURL = driver.getCurrentUrl();

		Assert.assertEquals(currentURL, expectedURL);
	}

}
