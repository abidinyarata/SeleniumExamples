package pack9;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		// capture id's for browser windows
		Set<String> windowIDs = driver.getWindowHandles();
		
		// Approach 1 - using List collection
		/*List<String> windowIdList = new ArrayList<String>(windowIDs);
		
		String parentWindowID = windowIdList.get(0);
		String childWindowID = windowIdList.get(1);
		
		//Swith to child window
		driver.switchTo().window(childWindowID);
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		
		//Switch to parent window
		driver.switchTo().window(parentWindowID);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		*/
		
		// Approach 2
		for(String winid:windowIDs)
		{
			String title=driver.switchTo().window(winid).getTitle();
			
			if( title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
			{
				driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
			}
		}
		
		//closing specific browser windows based on choice
		// 1-x  2-y  3-z  4-a  5-b...........
				
		/*for(String winid:windowIDs)
		{
			String title=driver.switchTo().window(winid).getTitle();
					
			if( title.equals("x") || title.equals("y") || title.equals("z"))
				driver.close();

		}*/
		
		// Close parent window
		/*for(String winid:windowIDs)
		{
			String title=driver.switchTo().window(winid).getTitle();
					
			if( title.equals("OrangeHRM"))
				driver.close();
		}*/

		// Close child window
		for(String winid:windowIDs)
		{
			String title=driver.switchTo().window(winid).getTitle();
					
			if( title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
				driver.close();
		}
	}
}