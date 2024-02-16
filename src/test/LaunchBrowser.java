package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LaunchBrowser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/apoorvsrivastava/eclipse-workspace/WebDriverProject/chromedriver");
		
		WebDriver driver = new ChromeDriver();  // WebDriver is interface
		
		driver.get("https://www.simplilearn.com");
		driver.manage().window().maximize();
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();

		
	}

}
