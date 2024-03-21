package utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ExeclDataProvider {
	
	WebDriver driver=null;
	
	@BeforeTest
	public void setUpTest() {
		driver=new ChromeDriver();
	}
	
	@Test (dataProvider="test1data")
	public void test1(String username,String password) throws InterruptedException {
		System.out.println(username+" |  "+password);
		driver.get("https://frontgate.com/UserLogonView?storeId=10053&catalogId=10053&langId=-1");
		driver.findElement(By.id("logonId")).sendKeys(username);
		driver.findElement(By.id("logonPassword")).sendKeys(password);
		driver.findElement(By.id("logonPassword")).sendKeys(Keys.ENTER);		
	}

	@DataProvider(name="test1data")
	public Object[][] getData() throws Exception {
		String excelPath="C:\\Users\\Msys\\eclipse-workspace\\seleniumJavaFramework\\excel\\data.xlsx";
		String sheetName="TestSheet";
		
		Object data[][]=testData(excelPath,sheetName);
		return data;
		
		
	}
	
	public Object[][] testData(String excelPath, String sheetName) throws Exception {
		ExeclUtils excel=new ExeclUtils(excelPath,sheetName);
		int rowCount=excel.getRowCount();
		int colCount=excel.getColCount();
		excel.writeExcel();
		
		Object data[][]=new Object[rowCount-1][colCount];
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				String username=excel.getCellDataString(i, j);
				System.out.print(username+" | ");
				data[i-1][j]=username;
				
			}
			System.out.println();
		}
		return data;
		
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		
	}

}
