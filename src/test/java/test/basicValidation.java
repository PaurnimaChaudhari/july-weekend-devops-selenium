package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
import org.testng.Reporter;
import org.testng.Assert;

public class basicValidation {
	
	//webDriver declaration
	
	public static WebDriver driver;
	
	String url = "https://www.facebook.com";
	
	//pre-activity
	@BeforeTest
	public void setup()
	{
		//open Chrome-browser
		driver = new ChromeDriver();
		//open the facebook-url
		
		driver.get(url);
	}
	//post-activity
	@AfterTest
	
	public void tearDown()
	{
		//the Chrome-browser will get closed after the test case is executed
		driver.quit();
	}
	@Test
	public void welcomeMessageValidation()
	{
		String expectedResult = "Facebook helps you connect and share with the people in your life.";
		String actualResult = driver.findElement(By.xpath("//h2[@class='_8eso']")).getText();
		
		Reporter.log("Expected Result = "+ expectedResult);
		Reporter.log("Actual Result = "+ actualResult);
		//compare
		Assert.assertTrue(actualResult.equals(expectedResult),"mismatch in the welcome result");
	}
	
	
	
	@Test
	public void emailTextBoxPlaceholderValidation()
	{
		String expectedResult = "Email address or phone number";
		String actualResult = driver.findElement(By.id("email")).getDomAttribute("placeholder");		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		//compare
		Assert.assertTrue(actualResult.equals(expectedResult),"mismatch in the email placeholder");

	}
	
	
	@Test
	public void passwordTextBoxPlaceholderValidation()
	{
		String expectedResult = "Password";
		String actualResult = driver.findElement(By.id("pass")).getDomAttribute("placeholder");		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		//compare
		Assert.assertTrue(actualResult.equals(expectedResult),"mismatch in the password placeholder");

	}
	
	

}
