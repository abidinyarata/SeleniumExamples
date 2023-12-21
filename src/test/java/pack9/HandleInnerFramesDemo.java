package pack9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleInnerFramesDemo {
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		// Frame 1
		WebElement frm1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		
		driver.switchTo().frame(frm1);
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("This is frame 1");
		
		driver.switchTo().defaultContent();
		
		// Frame 3
		WebElement frm3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		
		driver.switchTo().frame(frm3);
		
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("This is frame 3");
		
		// inner frame
		driver.switchTo().frame(0);

		driver.findElement(By.cssSelector("div.AB7Lab")).click(); // select first radio button in frame
		
		driver.switchTo().defaultContent();
		
		
		
		
		// TODOs
		// Frame 2
		// Frame 4
		// Frame 5
		
		

	}
}