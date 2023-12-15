package utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	public String userName, quantityToAdd;
	public int ExcelRowCount, ExcelColumnCount;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public void SwitchWindowToChild()
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1 =s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();		
		driver.switchTo().window(childWindow);
		String ChildWindowTitle = driver.getTitle();
		System.out.println(ChildWindowTitle);
		
	}
	
	public String ReadDatafromInputExcel(int NumberofRow) throws InvalidFormatException, IOException
	{
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData("C:\\Users\\USER\\eclipse-workspace\\CucumberFramework\\CucumberFramework\\src\\test\\resources\\Input Data.xlsx", "Sheet1");
			
		userName = testdata.get(NumberofRow).get("Name");	
		//quantityToAdd = testdata.get(NumberofRow).get("Quantity");
		return userName;
		
	}
	
}
