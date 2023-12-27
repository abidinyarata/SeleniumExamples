package pack14;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links : " + links.size());
		
		int brokenLinks = 0;
		
		for (WebElement linkElement : links) {
			String hrefAttributeValue = linkElement.getAttribute("href");
			
			// // pre-requisite for checking broken link
			if (hrefAttributeValue == null || hrefAttributeValue.isEmpty()) {
				System.out.println("href attribute value is empty.");
				continue;
			}
			
			URI linUri = new URI(hrefAttributeValue);
			URL linkurl = linUri.toURL();
			
			// send request to server - open, conncet
			HttpURLConnection conn = (HttpURLConnection)linkurl.openConnection();			
			conn.connect();
			
			if (conn.getResponseCode() >= 400) {
				System.out.println(hrefAttributeValue + " => Broken links");
				++brokenLinks;
			}
			else
				System.out.println(hrefAttributeValue+ " => Not Broken links");
		}
		
		System.out.println("Total number of broken links : " + brokenLinks);
	}
}