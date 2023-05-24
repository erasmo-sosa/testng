package testNg;

import org.testng.annotations.Test;

public class dependsOnMethods {

	@Test
	public void loginTest() {
		System.out.println("loginTest");
		//int i = 9/0;
	}
	@Test(dependsOnMethods="loginTest")
	public void homePageTest() {
		System.out.println("homePageTest");
	}
	@Test(dependsOnMethods="loginTest")
	public void searchPageTest() {
		System.out.println("homePageTest");
	}
	@Test(dependsOnMethods="loginTest")
	public void regPageTest() {
		System.out.println("homePageTest");
	}
}
