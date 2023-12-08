package pack3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorsDemo {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		// css with tag and id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Macbook");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Macbook");
		
		// css with tag and class
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Macbook");
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Macbook");
		
		// css with tag and attribute
		//driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Macbook");
		//driver.findElement(By.cssSelector("[name='q']")).sendKeys("Macbook");
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Macbook");
		//driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("Macbook");
		
		// css with tag class and attribute
		driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("Macbook");
		
	}
}