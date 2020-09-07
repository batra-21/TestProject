package ncs.demo.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DataEntryLocators {
	
	@FindBy(xpath ="//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input")
	public WebElement FirstName;
	
	@FindBy(xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/input")
	public WebElement LastName;
	
	@FindBy(xpath="//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div[2]/div[1]/div/div[1]/input")
	public WebElement DOB;
	
	@FindBy(xpath="//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div[2]/div[1]/div/div[1]/input")
	public WebElement NRIC;
	
	@FindBy(xpath="//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[1]/div[1]")
	public WebElement Nationality;
	
	@FindBy(xpath="//*[@id=\"mG61Hd\"]/div[2]/div/div[3]/div[1]/div[1]/div/span/span")
	public WebElement Submit;
	
	

}
