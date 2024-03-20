package seleniumJavaFramework;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String[] args) throws InterruptedException {
		//run on FireFox:
		//WebDriver driver=new FirefoxDriver();
		//run on chrome:
		WebDriver driver=new ChromeDriver();
		//run on IE
		//WebDriver driver=new InternetExplorerDriver();
		
		driver.get("http://google.com/");
		WebElement textBox= driver.findElement(By.id("APjFqb"));
		//or I can write: driver.findElement(By.id("input")).sendKeys("google scholar");
		textBox.sendKeys("google scholar");
		List<WebElement> listofInputElements= driver.findElements(By.xpath("//input"));
		int count=listofInputElements.size();
		System.out.println("Count of input elements: "+count);
		Thread.sleep(3000);
	
		driver.close();
		
		

	}

}
