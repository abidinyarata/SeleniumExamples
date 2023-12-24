package pack10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTableDemo {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// 1) Find total number of rows
		// int rows =
		// driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		// int rows = driver.findElements(By.tagName("tr")).size();

		System.out.println("Number of rows : " + rows);

		// 2) Find total number of columns
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		// int cols = driver.findElements(By.tagName("th")).size();

		System.out.println("Number of columns : " + cols);

		// 3) Read specific row & column data - Master In Java
		String str = driver.findElement(By.xpath("//table[@name='BookTable']//tr[6]//td[1]")).getText();
		System.out.println(str);

		// 4) Read data from all the rows & columns
		/*
		 * System.out.println("Book Name" + "     " + "Author" + "    " + "Subject" +
		 * "       " + "Price");
		 * 
		 * for (int r = 2; r < rows; ++r) { for (int c = 1; c <= cols; ++c) { str =
		 * driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td["
		 * + c + "]")).getText(); System.out.print(str + "\t"); } System.out.println();
		 * }
		 */

		// 5) Print book names whose author is Amit
		System.out.println("-----------------------------");
		System.out.println("Book Name \t\tAuthor");

		/*for (int r = 2; r <= rows; ++r) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[2]")).getText();
			if (!author.equals("Amit"))
				continue;
			for (int c = 1; c <= 2; ++c) {
				str = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]"))
						.getText();
				System.out.print(str + "\t");
			}
			System.out.println();
		}*/
		
		for(int r=2;r<=rows;r++)
		{
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
			
			if(author.equals("Amit"))
			{
				String bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
				System.out.println(bookname + "\t\t" +author);
			}			
		}
		
		// 6) Find sum of prices for all the books
		int sum = 0;
		for(int r=2;r<=rows;r++)
		{
			String strPrice = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[4]")).getText();
			int price = Integer.parseInt(strPrice);
			sum += price;
		}
		
		System.out.println("Total price : " + sum);
	}
}