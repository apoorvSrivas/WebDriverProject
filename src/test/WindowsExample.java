package test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WindowsExample {

	public static void main(String[] args) throws InterruptedException {


		
		System.setProperty("webdriver.chrome.driver", "/Users/apoorvsrivastava/eclipse-workspace/WebDriverProject/chromedriver");
		WebDriver driver = new ChromeDriver();  
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		
		WebElement newTab = driver.findElement(By.xpath("//button[@id='tabButton']"));
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("parent window is: "+parentWindow);  
		newTab.click();
		
		Set<String> allWindow = driver.getWindowHandles();  // This time there are multiple windows
		
		// Below is logic for finding child window till for loop ends
		String childWindow="";
		for(String win : allWindow)
		{
			System.out.println("The window ID is: "+win);
			if( ! win.equals(parentWindow))
			{
				childWindow =win;
			}
		}
		System.out.println("Child window is :"+childWindow);
		
		driver.switchTo().window(childWindow);  // Now driver will switch control to child window that opened by clicking on new tab.
		
		WebElement childWinHeader = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println("Header in child window is: "+childWinHeader.getText());
		
		
//		Thread.sleep(3000);
		driver.close(); // This will close child window not parent window coz control of driver is now with child window as we switched window.
		
		
		driver.switchTo().window(parentWindow);  // Now we'll again switch to parent window for other operations on main parent window
		WebElement newWindow = driver.findElement(By.id("windowButton"));
		

//		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='windowButton']")));
		
		
		    // Scrolling to a particular place of page which is first button where we clicked before on parent window, We don't need this scrolling 
		    // - here but we used it here as if we don't use it, the program does not work sometimes, reason is that on the button where we want to
		    // - click now does not appear as that is hidden behind the advertisement. Hence it sometimes show ElementInterceptionException.
			WebElement scrollTo = driver.findElement(By.xpath("//button[@id='tabButton']"));
			JavascriptExecutor obj = (JavascriptExecutor) driver;
			obj.executeScript("arguments[0].scrollIntoView();", scrollTo);
			
		newWindow.click(); // After scrolling when item appears clearly then clicking here. 
		
		
		
		// Below code for another new child window that appears when we click on just above element. Same code as above for child window
		allWindow = driver.getWindowHandles();
		for(String win : allWindow)
		{
			System.out.println("The window ID is: "+win);
			if( ! win.equals(parentWindow))
			{
				childWindow =win;
			}
		}
		System.out.println("Child window is :"+childWindow);
		
		driver.switchTo().window(childWindow); 
		
		childWinHeader = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println("Header in another child window is: "+childWinHeader.getText());
		
		
		driver.quit();  // It'll close all windows opened by selenium
		
		
		
	}

} 
