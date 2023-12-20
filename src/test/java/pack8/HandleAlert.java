package pack8;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlert {
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		//Alert alertWindow = driver.switchTo().alert();
		Alert alertWindow = mywait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(alertWindow.getText());
		
		//alertWindow.accept();   // this will close alert window using ok button
		alertWindow.dismiss();	// close alert window by using cancel button
	}
}