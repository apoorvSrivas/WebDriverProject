package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBsignUpTest {

	public static void main(String[] args) throws InterruptedException {


		
		System.setProperty("webdriver.chrome.driver", "/Users/apoorvsrivastava/eclipse-workspace/WebDriverProject/chromedriver");
		WebDriver driver = new ChromeDriver();  
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // If we don't use this wait, this program shows exception at runtime
		
		
		// create new account
		WebElement signUp = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signUp.click();
		WebElement fName = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lName = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		
		
		fName.sendKeys("Ajay");
		lName.sendKeys("Kumar");
		mobile.sendKeys("99999999999");
		password.sendKeys("Abc@1234");
		
		WebElement selectDay = driver.findElement(By.xpath("//select[@title='Day']/option[@selected='1']"));
		System.out.println("Dafault Selected day is: "+selectDay.getText() );
		
		WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
		Select ddDay = new Select(day);    // Select class is used for selecting from options.
		ddDay.selectByVisibleText("10");
//		ddDay.selectByValue("10");      We can either use selectByVisibleText or selectByValue
		
		
		WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
		Select ddMonth = new Select(month);    // Select class is used for selecting from options.
		ddMonth.selectByVisibleText("Aug");
//		ddMonth.selectByValue("8");
		
		
		WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
		Select ddYear = new Select(year);    // Select class is used for selecting from options.
		ddYear.selectByVisibleText("2010");
//		ddYear.selectByValue("2010");
		
		
		// Print List of all months under month drop down list
		List<WebElement> options = driver.findElements(By.xpath("//select[@title='Month']/option"));
		for(WebElement list : options)
		{
			System.out.println(list.getText());
		}
		
		
		// Clicking radio button HARDCODED, we should not hardcode like here we hardcoded female to get selected.
		WebElement female = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
		female.click();   
		
		// Suppose we get test data and that mentions where to click either male, female or custom, then we don't need to hardcode like above
		String gender = "Male";  // Suppose we get this data from test data sheet to select Male gender
		String genderXpath = "//label[text()='placeholder']";  // In place of placeholder, we'll replace whatever gender we get from test data
		String newXpath = genderXpath.replace("placeholder", gender);
		
		System.out.println("New xPath is: "+newXpath);
		WebElement genderEle = driver.findElement(By.xpath(newXpath));
		genderEle.click();
		
		// Either we can use above way of placeholder or below way using string concatenation to avoid hardcoding
//		String gender = "Custom";
//		String newXpath = "//label[text()='" + gender + "']";
//		WebElement genderEle = driver.findElement(By.xpath(newXpath));
//		genderEle.click();
//		System.out.println("New xPath is: "+newXpath);
		
		 
		
		
	}

}
