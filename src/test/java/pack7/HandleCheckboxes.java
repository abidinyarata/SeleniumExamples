package pack7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		//select specific one checkbox
		//driver.findElement(By.xpath("//input[@id='monday']")).click();
		
		//total number of checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		int totalCheckboxes = checkboxes.size();
		System.out.println("Total number of checkboxes : " + totalCheckboxes);
		
		/* List<WebElement> checkboxesText = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']/following-sibling::label[@class='form-check-label']"));
		
		//Select all the checkboxes
		for (int i = 0; i < totalCheckboxes; ++i) 
		{
			System.out.println(checkboxesText.get(i).getText());
			checkboxes.get(i).click();
		} 
		
		for (WebElement checkbox : checkboxes)
			checkbox.click();
		*/
		
		// Select last 2 checkboxes
		// Starting index = TotalNumberOfCheckboxes - howManyCheckboxesToBeSelected
		for (int i = totalCheckboxes - 2; i < totalCheckboxes; ++i)
			checkboxes.get(i).click();
		
		// Select first 2 checkboxes
		for (int i = 0; i < 2; ++i)
			checkboxes.get(i).click();
		
		Thread.sleep(3000);
		//clear/Uncheck checkboxes
		for (WebElement chk : checkboxes)
			if (chk.isSelected())
				chk.click();
		
			
	}
}