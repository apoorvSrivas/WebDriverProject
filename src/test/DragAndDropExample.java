package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropExample {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "/Users/apoorvsrivastava/eclipse-workspace/WebDriverProject/chromedriver");
		WebDriver driver = new ChromeDriver();  
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		WebElement From = driver.findElement(By.xpath("//a[text()=' BANK ']"));
		WebElement To = driver.findElement(By.xpath("//ol[@id='bank']/li"));
		
		Actions obj = new Actions(driver);
		
//		obj.sendKeys(Keys.PAGE_DOWN)
//		    .dragAndDrop(From, To)
//			.build()
//			.perform();
		
		obj.moveToElement(From).build().perform();  // MOUSE HOWER ACTION
		Thread.sleep(3000);
	
		obj.dragAndDrop(From, To).build().perform();   // Singly we can drag and drop like this. 
		
		
		
		
	Thread.sleep(4000);
	driver.close();
		
		
	}

}
