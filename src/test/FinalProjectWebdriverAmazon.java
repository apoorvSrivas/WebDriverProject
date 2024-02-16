package test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FinalProjectWebdriverAmazon {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "/Users/apoorvsrivastava/eclipse-workspace/WebDriverProject/chromedriver");
		WebDriver driver = new ChromeDriver();  
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));
		searchBar.sendKeys("Samsung mobile");
		
		WebElement searchButton =driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButton.click();
		
		List<WebElement> allMobile = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		List<WebElement> mobilePrice = driver.findElements(By.xpath("//div[@class='a-section']//span[@class='a-price-whole']"));
		List<WebElement> currencySymbol = driver.findElements(By.xpath("//div[@class='a-section']//span[@class='a-price-symbol']"));
		
		
		// Logic 1st to print name and price one by one like mobile name with price
		Iterator<WebElement> it1 = allMobile.iterator();    // Here I used Iterator so that both name and price can be printed one by one
		Iterator<WebElement> it2 = mobilePrice.iterator(); 
		while(it1.hasNext() && it2.hasNext())
		{
			WebElement value1= it1.next();
			WebElement value2= it2.next();
			System.out.println("Name of mobile: "+value1.getText());
			System.out.println("Price of mobile: "+value2.getText());
		}
		
		// Logic 2nd to print name and price one by one like mobile name with price
		for(int i=0; i<allMobile.size(); i++)
		{
			System.out.println("Mobile: "+allMobile.get(i).getText());
			System.out.println("Price: "+currencySymbol.get(i).getText()+" "+mobilePrice.get(i).getText());
		}
		
			
	}
}
