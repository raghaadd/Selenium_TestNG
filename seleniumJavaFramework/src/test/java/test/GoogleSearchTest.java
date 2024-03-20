package test;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	private static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		googleSearch();
		
	}
	
	public static void googleSearch() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("http://google.com/");
		//WebElement textBox= driver.findElement(By.id("APjFqb"));
		
		//search for google scholar and press enter:
		//textBox.sendKeys("google scholar",Keys.RETURN);
		GoogleSearchPage.textbox_search(driver).sendKeys("google scholar",Keys.RETURN);
		//GoogleSearchPage.button_search(driver).click();
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
