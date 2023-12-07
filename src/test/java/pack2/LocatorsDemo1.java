package pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo1 {
	
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		// Open App
		driver.get("http://www.automationpractice.pl/index.php?");
		driver.manage().window().maximize();
		
		// Search box
		driver.findElement(By.id("search_query_top")).sendKeys("T-shirt");
		
		// Search button
		driver.findElement(By.name("submit_search")).click();
		
		// link text & partial linktext
		driver.findElement(By.linkText("Blouse")).click();
	}
}