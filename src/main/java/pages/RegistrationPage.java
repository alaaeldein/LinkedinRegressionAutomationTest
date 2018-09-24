package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "first-name")
	WebElement firstNameTextbox;

	@FindBy(id = "last-name")
	WebElement lastNameTextbox;

	@FindBy(id = "join-email")
	WebElement emailTextbox;

	@FindBy(id = "join-password")
	WebElement passwordTextbox;

	@FindBy(id = "submit-join-form-text")
	WebElement submitRegistationButton;

	@FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[5]")
	WebElement recaptchaCheckbox;

	@FindBy(id = "ember1250")
	WebElement continueButton;

	@FindBy(id = "typeahead-input-for-title")
	WebElement jobTitleTextbox;

	@FindBy(id = "typeahead-input-for-company")
	WebElement currentCompanyTextBox;

	@FindBy(id = "work-industry")
	WebElement industryTextBox;

	@FindBy(id = "ember1584")
	WebElement secondContinueButton;

	public void registerNewUserInLinkedin(String firstName, String lastName, String email, String password)
			throws InterruptedException

	// ,String jobTitle, String currentCompany, String industry)

	{
		setTextValue(firstNameTextbox, firstName);
		setTextValue(lastNameTextbox, lastName);
		setTextValue(emailTextbox, email);
		setTextValue(passwordTextbox, password);
		clickButton(submitRegistationButton);

		Thread.sleep(20000);
		WebElement iFrame= driver.findElement(By.xpath("//*[@id=\"dialog\"]"));
		driver.switchTo().frame(iFrame);
		
		clickButton(recaptchaCheckbox);
	/*	clickButton(continueButton);
		
		 * setTextValue(jobTitleTextbox, jobTitle); setTextValue(currentCompanyTextBox,
		 * currentCompany); setTextValue(industryTextBox, industry);
		 * clickButton(secondContinueButton);
		 */

	}

}
