package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "/Users/apoorvsrivastava/eclipse-workspace/WebDriverProject/chromedriver");
		WebDriver driver = new ChromeDriver();  
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		
		List<WebElement> rows = driver.findElements(By.cssSelector("table#customers>tbody>tr"));
		System.out.println("Total number of rows in tablet are: "+rows.size());
		
//		List<WebElement> cols = driver.findElements(By.cssSelector("table#customers>tbody>tr>th"));
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='customers']//th"));  //table[@id='customers']/tbody/tr/th =  //table[@id='customers']//th  , These both are same
		System.out.println("Number of columns are: "+cols.size());
		
		WebElement data = driver.findElement(By.xpath("//table[@id='customers']//tr[4]/td[1]"));
		System.out.println("Table data of 3rd row 1st column is: "+data.getText());
		// table#customers>tbody>tr:nth-of-type(4)>td:nth-of-type(1)  is cssSelector path which is equal to xPath //table[@id='customers']//tr[4]/td[1]
		
		// Printing data of full table leaving first heading row---
		for(int i=2; i<=rows.size(); i++)
		{
			List<WebElement> columnsData = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[" +i+ "]/td"));
			System.out.println(columnsData.get(0).getText()+ "        "+columnsData.get(1).getText()+ "         "+columnsData.get(2).getText());	
			
		}
		
		
	}

}
