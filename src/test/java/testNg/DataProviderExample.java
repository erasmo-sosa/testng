package testNg;

import java.util.concurrent.TimeUnit;

import javax.sound.sampled.TargetDataLine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.annotations.Parameters;

public class DataProviderExample {

	private final short shortWait = 16;
	private final short mediumWait = 32;
	//private final String URL = "https://www.google.com";
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		String projectLocation = System.getProperty("user.dir");
		System.out.println("projectLocation: " + projectLocation);
		//Windows Driver
		//System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver_win.exe");
		//Macos Driver
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver_mac_112");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(shortWait,TimeUnit.SECONDS) ;			
		driver.manage().timeouts().pageLoadTimeout(mediumWait, TimeUnit.SECONDS );
		driver.manage().window().maximize();	
		driver.get("https://demo.gymforce.mx/");
		System.out.println("Driver Initiated");
	}
	
	//=========================================================================
	// DataProvider reads from a .xls file 
	//=========================================================================
	@DataProvider
	public void getData() {
		
	}

	@Test
	public void login(String username, String password, String otp) {
		
		
		String title = driver.getTitle();
		//System.out.println("Google Title is: " + title);
		Assert.assertEquals(title, "Gymforce");
		
		boolean b = driver.findElement(By.id("nombreu")).isDisplayed();
		Assert.assertTrue(b);
		
		//boolean b = driver.  findElement(By.linkText("Log in")).isDisplayed();
		boolean c = driver.findElement(By.id("btn_enviar")).isDisplayed();
		Assert.assertTrue(c);
		
		//boolean b = driver.findElement(By.linkText("Log in")).isDisplayed();
		driver.findElement(By.id("nombreu")).sendKeys("Erasmo");
		driver.findElement(By.id("pass")).sendKeys("Erasmo2022");
		driver.findElement(By.id("btn_enviar")).click();
		
		boolean d = driver.findElement(By.id("code")).isDisplayed();
		Assert.assertTrue(d);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
