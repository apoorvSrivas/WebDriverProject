package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {


		// Step1: Launch chrome and open simplilearn
		System.setProperty("webdriver.chrome.driver", "/Users/apoorvsrivastava/eclipse-workspace/WebDriverProject/chromedriver");
		WebDriver driver = new ChromeDriver();  
		driver.get("https://www.simplilearn.com");
		
		// step2: Maximize browser
		driver.manage().window().maximize();
		
		
		// Step3: click login link at top right corner
		System.out.println("The title of the page is :"+driver.getTitle());
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		String location = LoginLink.getAttribute("href");
		System.out.println("The link will take you to :"+location);
		LoginLink.click();
		

		// Step4: Enter username
		WebElement userName = driver.findElement(By.name("user_login"));
		userName.sendKeys("abc@xyz.com");
		
		
		
		// Step5: Enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Abc@1234");
		
		// Step6: Click remember me 
		WebElement checkBox = driver.findElement(By.id("remember-me"));
		checkBox.click();

		
		// Step7: Click "login" button
		WebElement login_button = driver.findElement(By.name("btn_login"));
		login_button.click();
		
		
		// Step8: Validate login was UNSUCCESSFUL
		WebElement error = driver.findElement(By.className("error_msg"));
		String errorMsg = error.getText();
		String expErrorMsg = "The email or password you have entered is invalid.";
		
		if(error.isDisplayed()  &&  errorMsg.equals(expErrorMsg))
			System.out.println("Test case passed.");
		else
			System.out.println("Test case failed.");
		
		// Step9: Find multiple elements not single element
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));  // NOTE: Here we use findElements not findElement, findElements returns List
		System.out.println("Total number of links on page are: "+allLinks.size());
		for(WebElement links : allLinks)
		{
			System.out.println(links.getAttribute("href"));
		}
		
		// Step10: Close browser
		driver.close();
		
		
       
		
		
		
		 
		
		
		
		
		
		
		
		
		
		
		
	}

}
