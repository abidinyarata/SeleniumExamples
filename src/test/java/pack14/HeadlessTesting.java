package pack14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessTesting {
	public static void main(String[] args) throws InterruptedException 
	{
		// Headless Mode
		
		////////      Chrome Browser     ///////////
		// Approach 1
		/* hromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		*/
		
		// Appraoch 2 WDM 5.1+
		/*ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();
		*/
		
		////////	    Edge Browser     ///////////
		// Appraoch 1
	    /*EdgeOptions options = new EdgeOptions();
	    options.addArguments("--headless");
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver(options);
		*/
		
		//Appraoch 2
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--headless");
		WebDriver driver = WebDriverManager.edgedriver().capabilities(options).create();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(3000);
			
		driver.findElement(By.name("username")).sendKeys("Admin");		 
		driver.findElement(By.name("password")).sendKeys("admin123");	
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		// validation
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		
		if(actualTitle.equals(expectedTitle))
			System.out.println("Login test passed");
		else
			System.out.println("Login Test failed");
	}
}