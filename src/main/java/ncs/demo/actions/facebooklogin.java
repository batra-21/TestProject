package ncs.demo.actions;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import ncs.demo.base.Page;
import ncs.demo.locators.facebookloginlocators;

public class facebooklogin extends Page{
	
	public facebookloginlocators fblocators;
	
	public facebooklogin()
	{
		this.fblocators = new facebookloginlocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.fblocators);
	}
	
	public void performLogin(String email, String password)
	{
		type(fblocators.email,email);
		type(fblocators.password,password);
		click(fblocators.login);
		
	}
	
	

}
