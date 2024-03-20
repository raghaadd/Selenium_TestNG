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
	
	
    public void writeExcel(String[] dataToWrite) throws IOException{
 
	    //Read excel sheet by sheet name    
	
	    //Sheet sheet = guru99Workbook.getSheet(sheetName);
	
	    //Get the current count of rows in excel file
    	
        File file =    new File("C:\\Users\\Msys\\eclipse-workspace\\seleniumJavaFramework\\excel\\data.xlsx");

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);
	    int rowCount=0;
	

	
	    //Get the first row from the sheet
	
	    Row row = sheet.getRow(0);
	
	    //Create a new row and append it at last of sheet
	
	    Row newRow = sheet.createRow(rowCount+1);
	
	    //Create a loop over the cell of newly created Row
	
	    for(int j = 0; j < row.getLastCellNum(); j++){
	
	        //Fill data in row
	
	        Cell cell = newRow.createCell(j);
	
	        cell.setCellValue(dataToWrite[j]);
	
	    }
	    
	    //Create an object of FileOutputStream class to create write data in excel file

	    FileOutputStream outputStream = new FileOutputStream(file);

	    //write data in the excel file

	    workbook.write(outputStream);

	    //close output stream

	    outputStream.close();
	    
		rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println("No. of rows After: "+rowCount);

	
    }

}
