package ncs.demo.actions;

import java.awt.MenuItem;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ncs.demo.base.Page;
import ncs.demo.locators.DataEntryLocators;
import ncs.demo.locators.facebookloginlocators;

public class DataEntry extends Page{
	
public DataEntryLocators datalocators;
	
	public DataEntry()
	{
		this.datalocators = new DataEntryLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.datalocators);
	}
	
	public void performSubmit(String firstname,String lastname,String dob,String nric,String nationality)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		type(datalocators.FirstName,firstname);
		type(datalocators.LastName,lastname);
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(datalocators.DOB));
		 * type(datalocators.DOB,dob);
		 */wait.until(ExpectedConditions.visibilityOf(datalocators.NRIC));
		wait.until(ExpectedConditions.elementToBeClickable(datalocators.NRIC));
		
		type(datalocators.NRIC,nric);
		
		
		
		wait.until(ExpectedConditions.visibilityOf(datalocators.Nationality));
		wait.until(ExpectedConditions.elementToBeClickable(datalocators.Nationality));
		click(datalocators.Nationality);
		
		
		  //WebElement nation = driver.findElement(By.cssSelector("span[class='quantumWizMenuPaperselectContent exportContent']"));
		  WebElement nation = datalocators.Nationality;
		  
		 // if(nation.isDisplayed())
		  //{ 
			  List<WebElement> menuitems = nation.findElements(By.xpath("//div[@role='option']/span"));
			  for(WebElement MenuItem : menuitems) 
			  {
				  if(MenuItem.getText().equalsIgnoreCase(nationality)) 
				  {
					  Actions action = new Actions(driver);
					action.moveToElement(MenuItem).perform();
						click(MenuItem);
		  break; 
		  }
		 }
		//}
		 
		
		/*
		 * WebElement nation =
		 * driver.findElement(By.xpath(".//span[contains(text(), '"+nationality+"')]"));
		 * 
		 * Actions action = new Actions(driver);
		 * action.moveToElement(nation).click().build(); action.perform();
		 */
		
		wait.until(ExpectedConditions.elementToBeClickable(datalocators.Submit));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(datalocators.Submit);
		
		
	}
	
	
	

}
