package pack7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDropDownWithoutSelectTag {
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		// Clicking on the dropdown
		driver.findElement(By.xpath("//button[contains(@class, 'multiselect')]")).click(); 
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container')]//label"));
		
		// Find total number of options
		int totalOptions = options.size();
		System.out.println("Total number of options : " + totalOptions);
		
		// Print all the options from dropdown
		
		// Using normal for loop
		for (int i = 0; i < totalOptions; ++i)
			System.out.println(options.get(i).getText());
		
		Thread.sleep(2000);
		
		// Select options from dropdown
		/* for (int i = 0; i < totalOptions; ++i) {
			String opt = options.get(i).getText();
			if (opt.equals("Java") || opt.equals("Python"))
				options.get(i).click();
		} */
		
		for (WebElement opt :options) {
			String optText = opt.getText();
			if (optText.equals("Java") || optText.equals("Python"))
				opt.click();
		}
	}
}