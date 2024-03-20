package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1_GoogleSearch {
	
	WebDriver driver=null;
	
	@BeforeTest
	public void setUpTest() {
		driver=new ChromeDriver();
	}
	
	@Test
	public void googleSearch() throws InterruptedException {
		
		driver.get("http://google.com/");
		WebElement textBox= driver.findElement(By.id("APjFqb"));
		//search for google scholar and press enter:
		textBox.sendKeys("google scholar",Keys.RETURN);
	
		
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		
	}

}
