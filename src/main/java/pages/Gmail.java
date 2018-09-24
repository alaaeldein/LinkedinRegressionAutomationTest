package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Gmail extends PageBase {

	public Gmail(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "تسجيل الدخول")
	WebElement loginButton;

	@FindBy(id = "identifierId")
	WebElement emailTextBox;

	@FindBy(id = "identifierNext")
	WebElement firstNextButton;

	@FindBy(name = "password")
	WebElement passwordTextBox;

	@FindBy(id = "passwordNext")
	WebElement secondNextButton;

	@FindBy(xpath = "/html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]"
			+ "/tbody/tr[1]/td[3]/a/span")
	WebElement firstEmailInList;

	@FindBy(linkText = "Reset my password")
	WebElement resendPasswordButton;

	public void loginIntoGmail(String googleEmail, String googlePassword) throws InterruptedException {

		clickButton(loginButton);

		setTextValue(emailTextBox, googleEmail);
		clickButton(firstNextButton);

		Thread.sleep(4000);

		setTextValue(passwordTextBox, googlePassword);
		clickButton(secondNextButton);

		Thread.sleep(10000);

	}

	public void openEnterNewPasswordPage() throws InterruptedException, AWTException {

		clickButton(firstEmailInList);
		Thread.sleep(2000);
		clickButton(resendPasswordButton);
		Thread.sleep(2000);
		
		
		
	}
}
