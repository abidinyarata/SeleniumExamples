package pack15;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {
	public static void main(String[] args) throws IOException 
	{
		//FileInputStream file = new FileInputStream("C:\\Users\\Asus\\Desktop\\selenium-tutorial\\WebDriverMavenProject\\testdata\\data.xlsx");
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");	//workbook.getSheetAt(0);
		
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Number of rows : " + totalRows);
		System.out.println("Number of cells : " + totalCells);
		
		for (int r = 0; r <= totalRows; ++r) {
			XSSFRow currentRow = sheet.getRow(r);
			
			for (int c = 0; c < totalCells; ++c) {
				String value = currentRow.getCell(c).toString();
				System.out.print(value + "\t\t");
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
	}
}