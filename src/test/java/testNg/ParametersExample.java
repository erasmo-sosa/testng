package testNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class ParametersExample {

	private final short shortWait = 16;
	private final short mediumWait = 32;
	//private final String URL = "https://www.google.com";
	WebDriver driver;
	
	//=========================================================================
	// Parameter are read from testng.xml file
	// Execute test from testng.xml file
	//=========================================================================
	
	@BeforeMethod
	@Parameters({"env", "browser", "url", "username"})
	public void setUp(String env, String browser, String url, String username) {
		
		System.out.println(env);
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		
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
		driver.get(url);
		System.out.println("Driver Initiated");
	}
	
	@Test(priority=0,groups="smoke suite")
	public void testOne(){
		String title = driver.getTitle();
		//System.out.println("Google Title is: " + title);
		Assert.assertEquals(title, "Google");
	}
	@Test(priority=1,groups="smoke suite")
	public void googleLog() {
		boolean b = driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
		Assert.assertTrue(b);
	}
	@Test(priority=2,groups="regression suite")
	public void mailLink() {
		boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
