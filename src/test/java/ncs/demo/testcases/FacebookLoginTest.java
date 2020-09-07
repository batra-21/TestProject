package ncs.demo.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import ncs.demo.actions.facebooklogin;

import ncs.demo.base.Page;
import ncs.demo.utilities.Utilities;

public class FacebookLoginTest extends Page{
	
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void facebookLoginTest(Hashtable<String,String> data)
	{
		Page.initConfiguration(data.get("url"));
		facebooklogin fblogin = new facebooklogin();
		fblogin.performLogin(data.get("email"),data.get("password"));
		try {
			
			Assert.assertTrue(driver.getPageSource().contains(data.get("username")));
		}
		catch(AssertionError e)
		{
			Assert.fail();
		}
	}
	@AfterMethod
	public void tearDown(){
		if(Page.driver!=null){
		Page.quitBrowser();
		}
	}

}
