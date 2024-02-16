package test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsExample {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "/Users/apoorvsrivastava/eclipse-workspace/WebDriverProject/chromedriver");
		WebDriver driver = new ChromeDriver();  
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		
		// Scrolling to a particulr place of page: 
		WebElement scrollTo = driver.findElement(By.xpath("//h1[text()='Alerts']"));		
		JavascriptExecutor objct = (JavascriptExecutor) driver;
		objct.executeScript("arguments[0].scrollIntoView();", scrollTo);
		
		
		WebElement button = driver.findElement(By.xpath("//button[@id='alertButton']"));
		button.click();
		Alert obj = driver.switchTo().alert();   
		Thread.sleep(1000);
		obj.accept();
		
		
		WebElement button1 = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		button1.click();
		obj = driver.switchTo().alert();   
		obj.dismiss();
		
		
	
	}

}
