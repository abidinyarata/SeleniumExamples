package pack16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	public static int getRowCount(String excelFilePath, String excelSheet) throws IOException 
	{
		fi = new FileInputStream(excelFilePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(excelSheet);
		
		int rowcount = ws.getLastRowNum();
		
		wb.close();
		fi.close();
		
		return rowcount;
	}

	public static int getCellCount(String excelFilePath, String excelSheet, int rowNumber) throws IOException 
	{
		fi = new FileInputStream(excelFilePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(excelSheet);
		row = ws.getRow(rowNumber);
		
		int cellcount = row.getLastCellNum();
		
		wb.close();
		fi.close();
		
		return cellcount;
	}

	public static String getCellData(String excelFilePath, String excelSheet, int rowNumber, int colNumber) throws IOException
	{
		fi = new FileInputStream(excelFilePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(excelSheet);
		row = ws.getRow(rowNumber);
		cell = row.getCell(colNumber);

		String data;
		try {
			// data=cell.toString();

			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
			return data;
		} catch (Exception e) {
			data = "";
		}

		wb.close();
		fi.close();
		return data;
	}

	public static void setCellData(String excelFilePath, String excelSheet, int rowNumber, int colNumber, String data) throws IOException 
	{
		fi = new FileInputStream(excelFilePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(excelSheet);
		row = ws.getRow(rowNumber);
		cell = row.createCell(colNumber);
		cell.setCellValue(data);
		fo = new FileOutputStream(excelFilePath);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public static void fillGreenColor(String excelFilePath, String excelSheet, int rowNumber, int colNumber) throws IOException 
	{
		fi = new FileInputStream(excelFilePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(excelSheet);
		row = ws.getRow(rowNumber);
		cell = row.getCell(colNumber);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(excelFilePath);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public static void fillRedColor(String excelFilePath, String excelSheet, int rowNumber, int colNumber) throws IOException
	{
		fi = new FileInputStream(excelFilePath);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(excelSheet);
		row = ws.getRow(rowNumber);
		cell = row.getCell(colNumber);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(excelFilePath);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
}