package pack12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo {
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		// Switch to frame
		driver.switchTo().frame("iframeResult");
		
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("Welcome");
		
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		Actions act = new Actions(driver);
		
		// Doublle click action
		act.doubleClick(button).perform();
		
		// Validation
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		
		//String copiedText = field2.getText();	// will not work
		String copiedText = field2.getAttribute("value");	// this will work
		
		if (copiedText.equals("Welcome"))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");
		
		System.out.println("Copied Text : " + copiedText);
	}
}