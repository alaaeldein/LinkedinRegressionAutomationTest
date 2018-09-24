package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (linkText = "Sign Up")
	WebElement signupButton;
	
	@FindBy (id = "login-email")
	WebElement emailTextbox;
	
	@FindBy (id = "login-password")
	WebElement passwordTextbox;
	
	@FindBy (id = "login-submit")
	WebElement loginButton;
	
	@FindBy (linkText = "Forgot password?")
	WebElement forgotPasswordButton;
		
	
	public void openLinkedinSignupPage () {
		
		clickButton(signupButton);
	}
	
	public void loginIntoLinkedin (String email, String password) {
		
		setTextValue(emailTextbox, email);
		setTextValue(passwordTextbox, password);
		clickButton(loginButton);	
	}
	
	public void openForgotPasswordPage () {
		
		clickButton(forgotPasswordButton);
	}

}
