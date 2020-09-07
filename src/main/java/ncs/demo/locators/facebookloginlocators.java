package ncs.demo.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class facebookloginlocators {
	
	@FindBy(css="input[id='email']")
	public WebElement email;
	
	@FindBy(css="input[id='pass']")
	public WebElement password;
	
	@FindBy(css="input[type='submit']")
	public WebElement login;

}
