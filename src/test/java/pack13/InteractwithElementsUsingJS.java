package pack13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractwithElementsUsingJS {
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		//ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//JavascriptExecutor js = driver;
		
		// First name - inputbox
		WebElement inputbox = driver.findElement(By.id("name"));
		js.executeScript("arguments[0].setAttribute('value','john')", inputbox);
		
		//	Radio button
		WebElement maleRd = driver.findElement(By.id("male"));
		//maleRd.click();  //ClickInterceptedException
		js.executeScript("arguments[0].click();", maleRd);
				
		//	Checkbox
		WebElement chkbox = driver.findElement(By.id("sunday"));
		js.executeScript("arguments[0].click();", chkbox);
				
		driver.switchTo().frame("frame-one796456169");
		
		// button
		WebElement button = driver.findElement(By.id("FSsubmit"));
		js.executeScript("arguments[0].click();", button);		
	}
}