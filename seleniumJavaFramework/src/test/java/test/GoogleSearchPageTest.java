package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	private static WebDriver driver=null;
	
	public static void main(String[] args) throws InterruptedException  {
		googleSearchTest();
		
	}
	public static void googleSearchTest() throws InterruptedException {
		driver=new ChromeDriver();
		
		GoogleSearchPageObjects searchPageObj=new GoogleSearchPageObjects(driver);
		driver.get("http://google.com/");
		searchPageObj.setTextInSearchBox("google scholar");
		searchPageObj.clickSearchButton();
		Thread.sleep(3000);
		driver.close();
		
	}

}
