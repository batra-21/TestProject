package ncs.demo.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import ncs.demo.base.Page;

public class Utilities extends Page{

	public static String screenshotName;
	
	@DataProvider(name = "dp")
	public Object[][] getData(Method m)
	{
		String sheetName = m.getName();
		int Rows = excel.getRowCount(sheetName);
		int Cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[Rows-1][1];
		
		Hashtable<String,String> table = null;
		
		for(int rowNum = 2;rowNum <= Rows; rowNum++)
		{
			table = new Hashtable<String,String>();
			for (int colNum = 0;colNum< Cols; colNum++)
			{
				table.put(excel.getCellData(sheetName, colNum, 1),excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum -2][0] = table;
			}
		}
		return data;
		
	}
	
	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}


}



