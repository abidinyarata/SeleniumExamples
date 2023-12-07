package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NopCommerceLoginTest {

	public static void main(String[] args) throws InterruptedException 
	{
		//1) Launch browser
		WebDriver driver = new ChromeDriver();
		
		//2) open url - URL: https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		
		//3) Provide username  - admin@yourstore.com
		WebElement txtEmailBox = driver.findElement(By.name("Email"));
		txtEmailBox.clear();
		txtEmailBox.sendKeys("admin@yourstore.com");
		
		//4) Provide password  - admin
		WebElement txtPasswordBox = driver.findElement(By.name("Password"));
		txtPasswordBox.clear();
		txtPasswordBox.sendKeys("admin");
		
		//5) Click on Login button 
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		
		//6) Verify the title of dashboard page Exp title : Dashboard / nopCommerce administration
		//String actualTitle = driver.findElement(By.xpath("/html/head/title")).getText();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		
		System.out.println(expectedTitle);
		System.out.println(actualTitle);
		
		if (actualTitle.equals(expectedTitle))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");
	}

}
