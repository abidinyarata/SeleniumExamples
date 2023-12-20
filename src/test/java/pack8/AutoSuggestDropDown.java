package pack8;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropDown {
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("selenium");
		
		Thread.sleep(3000);
		
		List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
		
		int totalSuggestions = list.size();
		
		System.out.println("Number of suggestions : " + totalSuggestions);
		
		for (WebElement elem :list)
			if (!elem.getText().equals(""))
				System.out.println(elem.getText());
		
		for (int i = 0; i < totalSuggestions; ++i) {
			String text = list.get(i).getText();
			if (text.equals("selenium python")) {
				list.get(i).click();
				break;
			}
		}
	}
}