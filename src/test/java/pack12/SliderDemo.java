package pack12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		//Min slider
		WebElement minSlider = driver.findElement(By.xpath("//span[1]"));
		System.out.println("Current location of min slider : " + minSlider.getLocation());  // (59, 250)
				
		act.dragAndDropBy(minSlider, 100, 250).perform();
		System.out.println("Location of min slider after moving : " + minSlider.getLocation());  

		//Max slider
		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Current location of max slider : " + maxSlider.getLocation());   // (612, 250)
				
		act.dragAndDropBy(maxSlider, -96, 250).perform();
		System.out.println("Location of max slider after moving : " + maxSlider.getLocation()); 
	}
}