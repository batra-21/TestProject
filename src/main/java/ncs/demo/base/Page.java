package ncs.demo.base;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ncs.demo.utilities.ExcelReader;
import ncs.demo.utilities.ExtentManager;


public class Page {
	
	
	public static WebDriver driver;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\ncs\\demo\\excel\\testdata.xlsx");
	
	public static ExtentReports rep = ExtentManager.getInstance();
	
	public static ExtentTest test;
	
	public static String browser;
	
	
	public static void initConfiguration(String url)
	{
		
		if(Constant.Browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\ncs\\demo\\executables\\chromedriver.exe");
			log.debug("launching chrome");
			driver = new ChromeDriver();
			
		}
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Constant.implicitwait, TimeUnit.SECONDS)
	}
	
	public static void click(WebElement element)
	{
		
		element.click();
		test.log(LogStatus.INFO, "clicking on element" + element);
		
	}
	
	public static void type(WebElement element, String value) {

		element.sendKeys(value);

		log.debug("Typing in an Element : "+element+" entered value as : "+value);
		
		test.log(LogStatus.INFO, "Typing in : " + element + " entered value as " + value);

	}
	
	public static void select(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByVisibleText(value);

		test.log(LogStatus.INFO, "Selecting from dropdown : " + element + " value as " + value);

		log.debug("Typing in an Element : "+element+" entered value as : "+value);
		
		test.log(LogStatus.INFO, "Typing in : " + element + " entered value as " + value);

	}
	
	public static void quitBrowser()
	{
		
			driver.quit();
		
	}

}
