package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLoginTest {

	public static void main(String[] args) throws InterruptedException 
	{
		// Before 4.6.0 need setup driver
		//WebDriverManager.chromedriver().setup();
		
		// 1. Launch browser
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		
		// 2. open url - https://opensource-demo.orangehrmlive.com/
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		// 3. Provide username  - Admin
		//WebElement txtUserName =  driver.findElement(By.name("username"));
		//txtUserName.sendKeys("Admin");
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		// 4. Provide password  - admin123
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		// 5. Click on Login button 
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		Thread.sleep(3000);
		
		// 6. Verify the title of dashboard page  Exp title : OrangeHRM
		
		// Title Validation
		/* String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		
		if (actualTitle.equals(expectedTitle))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");
		*/
		
		// Label Validation
		String actualLabel = "";
		try {
			actualLabel = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		} 
		catch (NoSuchElementException e) {
			
		}
		
		String expectedLabel = "Dashboard";
		
		if (actualLabel.equals(expectedLabel))
			System.out.println("Tested passed");
		else
			System.out.println("Tested failed");
		
		Thread.sleep(3000);
		
		// 7. Close browser
		//driver.close();
		driver.quit();
	}

}
