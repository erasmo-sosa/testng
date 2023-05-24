package testNg;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class Annotations {

	// Preconditions
	@BeforeSuite
	public void envSetup() {
		System.out.println("1. Setup System Properties for Chrome");
	}
	@BeforeTest
	public void launchBrowser() {
		System.out.println("2. Launch Chrome Browser");

	}	
	@BeforeClass
	public void enterURL(){
		System.out.println("3. Enter URL");
	}
	@BeforeMethod
	public void login() {
		System.out.println("4. Login to App");
	}

	//Test Cases
	@Test(priority = 0)
	public void browserTitle() {
		System.out.println("Browser Title is verified");
	}
	@Test(priority = 1)
	public void searchTest() {
		System.out.println("Search Test");
	}
	@Test(priority = 2)
	public void googleLogo() {
		System.out.println("Verify Google Logo");
	}
	
	// Post Conditions
	@AfterMethod
	public void logOut() {
		System.out.println("6. Log out from App");
	}
	
	@AfterClass
	public void deleteCookies() {
		System.out.println("7. Delete Browser Cookies");
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("8. Close Browser");
		//driver.quit
	}
	
	@AfterSuite
	public void generateTestReport() {
		System.out.println("Generate Report");
	}
}
