package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPasswordPage extends PageBase{

	public NewPasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (id = "newPassword")
	WebElement newPasswordTextbox;
	
	@FindBy (id = "confirmPassword")
	WebElement confirmPasswordTextbox;
	
	@FindBy (id = "reset-password-submit-button")
	WebElement submitNewPasswordButton;
	
	@FindBy (id = "reset-password-submit-button")
	WebElement goToHomePageButton;
	
	
	public void insertNewPassword (String password, String confirmPassword) {
		
		setTextValue(newPasswordTextbox, password);
		setTextValue(confirmPasswordTextbox, confirmPassword);
		clickButton(submitNewPasswordButton);
	}
	
	public void openLinkedinHomePage () {
		
		clickButton(goToHomePageButton);
	}
	
}
