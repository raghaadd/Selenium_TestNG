package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNG_Demo {
	public static void main(String[] args) throws InterruptedException {
		googleSearch();
		
	}
	
	public static void googleSearch() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com/");
		WebElement textBox= driver.findElement(By.id("APjFqb"));
		//search for google scholar and press enter:
		textBox.sendKeys("google scholar",Keys.RETURN);
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
