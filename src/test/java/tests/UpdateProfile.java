package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class UpdateProfile extends TestBase {

	ProfilePage profilePageObj;
	LoginPage loginPageObj;
	HomePage homePageObj;

	
	@Test(priority = 0)
	public void openProfilePage() throws InterruptedException {

		homePageObj = new HomePage(driver);
		homePageObj.openProfilePage();
	}

	@DataProvider(name = "add experience data")
	public Object[][] addExperienceData() throws IOException {

		ExcelReader excelReaderObj = new ExcelReader();

		return excelReaderObj.getExcelData(4, 1, 5);

	}

	@Test(priority = 1, dataProvider = "add experience data", dependsOnMethods = "openProfilePage")
	public void addExperience(String Title, String Company, String Month, String Year, String Description)
			throws InterruptedException {

		profilePageObj = new ProfilePage(driver);
		profilePageObj.openAddExperiencePopup();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("position-title-typeahead")));

		profilePageObj.addExperience(Title, Company, Month, Year, Description);
		
		Thread.sleep(3000);
		String expectedURL = "https://www.linkedin.com/in/isamill-rafatt-893619170/";
		String currentURL = driver.getCurrentUrl();

		Assert.assertEquals(currentURL, expectedURL);

	}

	@DataProvider(name = "add education data")
	public Object[][] addEducationData() throws IOException {

		ExcelReader excelReaderObj = new ExcelReader();

		return excelReaderObj.getExcelData(5, 1, 4);

	}

	@Test(priority = 2, dataProvider = "add education data", dependsOnMethods = "addExperience")
	public void addEducation(String schoolName, String bachelor, String studyField, String grade)
			throws InterruptedException {

		profilePageObj = new ProfilePage(driver);
		profilePageObj.openAddEducationPopup();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edu-school-typeahead")));

		profilePageObj.addEducation(schoolName, bachelor, studyField, grade);
		
		Thread.sleep(3000);
		String expectedURL = "https://www.linkedin.com/in/isamill-rafatt-893619170/";
		String currentURL = driver.getCurrentUrl();

		Assert.assertEquals(currentURL, expectedURL);

	}

	@DataProvider(name = "add summary data")
	public Object[][] addSummaryData() throws IOException {

		ExcelReader excelReaderObj = new ExcelReader();

		return excelReaderObj.getExcelData(6, 1, 1);

	}

	@Test(priority = 3, dataProvider = "add summary data", dependsOnMethods = "addEducation")
	public void addSummary(String summary) throws InterruptedException {

		profilePageObj = new ProfilePage(driver);
		profilePageObj.openProfileSummarySectionPopup();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topcard-summary")));

		profilePageObj.addSummaryForProfile(summary);
		
		Thread.sleep(3000);
		String expectedURL = "https://www.linkedin.com/in/isamill-rafatt-893619170/";
		String currentURL = driver.getCurrentUrl();

		Assert.assertEquals(currentURL, expectedURL);

	}
	
	@DataProvider(name = "add course data")
	public Object[][] addCourseData() throws IOException {

		ExcelReader excelReaderObj = new ExcelReader();

		return excelReaderObj.getExcelData(7, 1, 1);

	}

	@Test(priority = 4, dataProvider = "add course data", dependsOnMethods = "addSummary")
	public void addCourse(String Course) throws InterruptedException {

		profilePageObj = new ProfilePage(driver);
		profilePageObj.openAddCoursePopup();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("course-name")));

		profilePageObj.addCourse(Course);
		
		Thread.sleep(3000);
		String expectedURL = "https://www.linkedin.com/in/isamill-rafatt-893619170/";
		String currentURL = driver.getCurrentUrl();

		Assert.assertEquals(currentURL, expectedURL);

	}
	

}
