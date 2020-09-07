package ncs.demo.testcases;

import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ncs.demo.actions.DataEntry;
import ncs.demo.base.Page;
import ncs.demo.errorcollectors.ErrorCollectors;
import ncs.demo.utilities.Utilities;

public class DataEntryTest extends Page{
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void dataEntryTest(Hashtable<String,String> data)
	{
		Page.initConfiguration(data.get("url"));
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,1000)");
		DataEntry dataentry = new DataEntry();
		dataentry.performSubmit(data.get("firstname"), data.get("lastname"), data.get("dob"), data.get("nric"), data.get("nationality"));
		
		ErrorCollectors.verifyEquals(driver.getCurrentUrl(), "https://docs.google.com/forms/u/0/d/e/1FAIpQLSd9UPxM2Vv-SMLen1t7NGbnIdS_w_MDvNihp8u8CnPI1YJrcA/formResponse");
	}
	
	@AfterMethod
	public void tearDown(){
		if(Page.driver!=null){
		Page.quitBrowser();
		}
	}

}
