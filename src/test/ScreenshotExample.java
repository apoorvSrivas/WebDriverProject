package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;  // For File utils like taking screenshot 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotExample {

	public static void main(String[] args) throws IOException {


		System.setProperty("webdriver.chrome.driver", "/Users/apoorvsrivastava/eclipse-workspace/WebDriverProject/chromedriver");
		WebDriver driver = new ChromeDriver();  
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		
		TakesScreenshot obj = (TakesScreenshot) driver;
		File fileObj = obj.getScreenshotAs(OutputType.FILE);
//		File screenshot = new File("/Users/apoorvsrivastava/Downloads/SeleniumScreenShots/image.jpg");  // If we want screenshots to be saved here in WebDriverProject, we can simply write file name like "image.jpg"
		
		File screenshot = new File("src/Screenshots/image1.jpg");
		FileUtils.copyFile(fileObj, screenshot );
		
	}
}
