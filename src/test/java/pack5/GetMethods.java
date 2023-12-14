package pack5;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		System.out.println("Title of page : " +  driver.getTitle());
		System.out.println("Current Url : " + driver.getCurrentUrl());
		
		System.out.println("Page Source.............");
		String ps = driver.getPageSource();
		//System.out.println(ps);
		System.out.println(ps.contains("html"));
		
		System.out.println("CD Wİndow :" + driver.getWindowHandle());
		// 1. run CD Wİndow :876055BB3384FECC6610845C65B1153C
		// 2. CD Wİndow :9029541EB9FF1F8577C1DFAE85DB2723
		// Everytime it changes
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		
		for (String windId : windowIds)
			System.out.println(windId);
	}

}