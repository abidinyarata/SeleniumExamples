package pack5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();

		// isDisplayed() isEanabled()
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Display status of logo : " + logo.isDisplayed());
		
		boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println(status);
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Display status : " + searchBox.isDisplayed());
		System.out.println("Enable status : " + searchBox.isEnabled());
		
		// isSelected
		WebElement male_rd = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		// Before Selection
		System.out.println("Before selection...........");
		System.out.println("Male radio button :" + male_rd.isSelected());
		System.out.println("Female radio button :" + female_rd.isSelected());
		
		// After selection of male radio Button
		System.out.println("After selection of male radio button......");
		female_rd.click();
		System.out.println("Male radio button :" + male_rd.isSelected());
		System.out.println("Female radio button :" + female_rd.isSelected());
		
		// After selection of female radio Button
		System.out.println("After selection of female radio button......");
		female_rd.click();
		System.out.println("Male radio button :" + male_rd.isSelected());
		System.out.println("Female radio button :" + female_rd.isSelected());
	}

}