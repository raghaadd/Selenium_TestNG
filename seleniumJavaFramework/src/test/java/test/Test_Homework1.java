package test;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_Homework1 {
	
	WebDriver driver=null;
	
	@BeforeTest
	public void setUpTest() {
		driver=new ChromeDriver();
	}
	
	@Test
	public void googleSearch2() throws InterruptedException {
		
		//open the website:
		driver.get("http:ballarddesigns.com/");
		//navigate to the sign in page
		driver.findElement(By.id("loginMyAccount")).click();
		
		//
        // Define the expected text
        String expectedText = "Welcome back! To access your account, please enter your email address and password and click Sign In.";
		WebElement actualTextElement= driver.findElement(By.xpath("//*[@id=\"BDLoginMessageNormal\"]/p[1]"));
		String actualText=actualTextElement.getText();
		System.out.println(actualText);   
        // Verify the text
        Assert.assertEquals(actualText, expectedText, "Actual text doesn't match expected text");
        
		driver.findElement(By.id("logonId")).sendKeys("test@testqa2024.com");
		driver.findElement(By.id("logonPassword")).sendKeys("wtx@91187");
		driver.findElement(By.id("logonPassword")).sendKeys(Keys.ENTER);
		
		// Check if the "My Account" button exists
	    WebElement myAccountButton = driver.findElement(By.id("myAccount"));
	    Assert.assertTrue(myAccountButton.isDisplayed(), "My Account button is not displayed");
	    
	    //check "welcome user"
	    WebElement welcomeTextElement = driver.findElement(By.id("welcome"));
	    String welcomeTextString=welcomeTextElement.getText();
	    System.out.println(welcomeTextString);
	    String[] parts = welcomeTextString.split(",\\s*");
	    String ActualName = parts[1].substring(0, parts[1].length() - 1); 
	    System.out.println(ActualName); 
	    String expctedName="test";
	    // Verify the name
        Assert.assertEquals(ActualName, expctedName, "Actual name doesn't match expected name");
	    
	    		
		
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		
	}

}
