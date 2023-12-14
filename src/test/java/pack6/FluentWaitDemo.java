package pack6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitDemo {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		//Fluent wait declaration
		
		FluentWait mywait=new FluentWait(driver);
		mywait.withTimeout(Duration.ofSeconds(30));
		mywait.pollingEvery(Duration.ofSeconds(5));
		mywait.ignoring(NoSuchElementException.class);
				
					
		//usage
		WebElement username=(WebElement) mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		username.sendKeys("Admin");
	}

}