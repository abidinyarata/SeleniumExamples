package pack11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0); //switch to frame
		
		//Appraoch 1
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/15/2022"); // mm/dd/yyyy
		
		//Approach2	
		String year = "2024";
		String month = "October";
		String day = "12";
				
		driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // will open the date picker
		
		//select month & year
		while(true) {
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(mon.equals(month) && yr.equals(year))
				break;
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();  // Future date
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();   //Past date		
		}
		
		//select day
		//List<WebElement> allDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		List<WebElement> allDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement dt : allDays) 
			if(dt.getText().equals(day)) {
				dt.click();
				break;
			}
		
		/*for(int i = 0; i < allDays.size(); i++)
			if(allDays.get(i).getText().equals(day)) {
				allDays.get(i).click();
				break;
			}*/
	}
}