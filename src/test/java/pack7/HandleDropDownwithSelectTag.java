package pack7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDownwithSelectTag {
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		WebElement dropdownCountryElement = driver.findElement(By.xpath("//select[@id='country-list']"));
		Select dropdownCountry = new Select(dropdownCountryElement);
		
		// 1) Selecting an option from the dropdown
		//dropdownCountry.selectByVisibleText("USA");
		//dropdownCountry.selectByValue("4");
		dropdownCountry.selectByIndex(3);
		
		// 2) Find total options in dropdown
		List<WebElement> options = dropdownCountry.getOptions();
		int totalOptions = options.size();
		System.out.println("Total number of options : " + totalOptions);
		
		//3) print options in console window
		//for (int i = 0; i < totalOptions; ++i)
		//	System.out.println(options.get(i).getText());
		
		//using enhanced loop
		for (WebElement opt :options)
			System.out.println(opt.getText());
	}
}