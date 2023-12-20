package pack8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertwithInputbox {
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		Alert alertWindow = driver.switchTo().alert();
		
		System.out.println("Alert Text : " + alertWindow.getText());
		
		alertWindow.sendKeys("welcome");
		
		alertWindow.accept();
		//alertWindow.dismiss();
		
		// validation
		
		String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String expectedText = "You entered: welcome";
		
		if (actualText.equals(expectedText))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");
	}
}