package utils;

public class ExcelUtilDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExeclUtils excel=new ExeclUtils("C:\\Users\\Msys\\eclipse-workspace\\seleniumJavaFramework\\excel\\data.xlsx", "sheet1");
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);

	}

}
