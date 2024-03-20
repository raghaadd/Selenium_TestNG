package seleniumJavaFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDeom {
	
	private static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		driver=new InternetExplorerDriver();
		driver.get("http://google.com/");
		WebElement textBox= driver.findElement(By.id("APjFqb"));
		textBox.sendKeys("google scholar",Keys.RETURN);
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		

	}

}
