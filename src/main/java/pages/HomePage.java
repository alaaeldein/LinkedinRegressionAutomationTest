package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "nav-settings__dropdown-trigger")
	WebElement userMenuButton;
	
	@FindBy (linkText = "Sign out")
	WebElement signoutButton;
	
	@FindBy (css = "div.nav-settings__linkcard.nav-settings__block")
	WebElement viewProfileButton;
	
	public void performSignout () {
		
		clickButton(userMenuButton);
		clickButton(signoutButton);
	}
	
	public void openProfilePage () throws InterruptedException {
		
		clickButton(userMenuButton);
		clickButton(viewProfileButton);
		Thread.sleep(3000);
	}


}
