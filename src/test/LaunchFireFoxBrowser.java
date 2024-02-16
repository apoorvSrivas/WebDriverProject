package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFireFoxBrowser {

	public static void main(String[] args) {


		
        System.setProperty("webdriver.gecko.driver", "/Users/apoorvsrivastava/eclipse-workspace/WebDriverProject/geckodriver");
		
		WebDriver driver = new FirefoxDriver();  // WebDriver is interface
		
		driver.get("https://www.simplilearn.com");
		driver.manage().window().maximize();
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
	}

}