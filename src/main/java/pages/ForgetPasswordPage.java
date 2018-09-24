package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPasswordPage extends PageBase{

	public ForgetPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "username")
	WebElement usernameTextbox;
	
	@FindBy (id = "reset-password-submit-button")
	WebElement resetPasswordSubmitButton;
	
	
	public void forgetPassword (String email) {
		
		setTextValue(usernameTextbox, email);
		clickButton(resetPasswordSubmitButton);
	}
	
	
}
