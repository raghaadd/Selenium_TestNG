package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExeclUtils {
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	
	
	public ExeclUtils(String excelPath, String sheetName) {
		try {
			workbook=new XSSFWorkbook(excelPath);
			sheet=workbook.getSheet(sheetName);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		getRowCount();
		getColCount();
		getCellDataString(0,0);
		getCellDataNumber(1,1);
	}
	
	public static int getRowCount() {
		int rowCount=0;
		try {
			rowCount=sheet.getPhysicalNumberOfRows();
			System.out.println("No. of rows: "+rowCount);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowCount;
	
	}
	
	public static int getColCount() {
		int colCount=0;
		try {
			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No. of col: "+colCount);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
	
	}
	
	public static String getCellDataString(int rowNum, int colNum) {
		String cellData=null;
		try {
			cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(cellData);
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
		
	}
	
	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			XSSFWorkbook workbook=new XSSFWorkbook("C:\\Users\\Msys\\eclipse-workspace\\seleniumJavaFramework\\excel\\data.xlsx");
			XSSFSheet sheet=workbook.getSheet("sheet1");
			double cellData=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(cellData);
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	}
	
	
    public void writeExcel() throws Exception{
    	XSSFWorkbook workbook=new XSSFWorkbook();
    	XSSFSheet sheet=workbook.createSheet("TestSheet");
    	
    	String[][] valueToWrite = {{"email","password"},{"test@testqa2024"," "},{"test@testqa2024.com","12345rr"},{"test@testqa2024.com","wtx@91187"}};
    	
    	for(int i=0;i<valueToWrite.length;i++) {
        	sheet.createRow(i);
        	sheet.getRow(i).createCell(0).setCellValue(valueToWrite[i][0]);
        	sheet.getRow(i).createCell(1).setCellValue(valueToWrite[i][1]);
    	}
    	File file=new File("C:\\Users\\Msys\\eclipse-workspace\\seleniumJavaFramework\\excel\\data.xlsx");
    	FileOutputStream fos=new FileOutputStream(file);
    	
    	workbook.write(fos);
    	workbook.close();
    	
//    	sheet.createRow(0);
//    	sheet.getRow(0).createCell(0).setCellValue("email");
//    	sheet.getRow(0).createCell(1).setCellValue("password");
//    	
//    	sheet.createRow(1);
//    	sheet.getRow(1).createCell(0).setCellValue("test@testqa2024");
//    	sheet.getRow(1).createCell(1).setCellValue(" ");
//    	
//    	sheet.createRow(2);
//    	sheet.getRow(2).createCell(0).setCellValue("test@testqa2024.com");
//    	sheet.getRow(2).createCell(1).setCellValue("12345r");
//    	
//    	sheet.createRow(3);
//    	sheet.getRow(3).createCell(0).setCellValue("test@testqa2024.com");
//    	sheet.getRow(3).createCell(1).setCellValue("wtx@91187");
    	

    	
	
    }

}
