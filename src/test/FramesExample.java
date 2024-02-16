package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesExample {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "/Users/apoorvsrivastava/eclipse-workspace/WebDriverProject/chromedriver");
		WebDriver driver = new ChromeDriver();  
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		
//		// Scrolling so that frame is visible on page and ads can't hide frame: 
//		WebElement scrollTo = driver.findElement(By.xpath("//h1[text()='Frames']/following-sibling::*"));	
//		JavascriptExecutor obj = (JavascriptExecutor) driver;
//		obj.executeScript("arguments[0].scrollIntoView();", scrollTo);
		
		
		driver.switchTo().frame("frame1");
		WebElement newTab = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(newTab.getText());
		
		driver.switchTo().defaultContent();  // After going to frame, we're coming back to main frame (main window).
		
		
	}

}
