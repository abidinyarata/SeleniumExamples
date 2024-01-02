package pack15;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {
	public static void main(String[] args) throws IOException
	{
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\myfile.xlsx");
		
		// Create workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// Create sheet
		XSSFSheet sheet = workbook.createSheet();
		
		//Creating rows, cells and update data without loop
		XSSFRow row1 = sheet.createRow(0);
						
		row1.createCell(0).setCellValue("welcome");
		row1.createCell(1).setCellValue("12345");
		row1.createCell(2).setCellValue("xyz");
						
		XSSFRow row2 =sheet.createRow(1);
		
		row2.createCell(0).setCellValue("abc");
		row2.createCell(1).setCellValue("4567");
		row2.createCell(2).setCellValue("testing");
		
		workbook.write(file);
		workbook.close();
		file.close();

		System.out.println("Writing is successfully done!");
	}
}