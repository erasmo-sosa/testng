package testNg;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class Exceptions {
	
	@Test(timeOut = 2000)
	public void neverEndingTest() throws Exception {
		Thread.sleep(5000);
		System.out.println("homePageTest");
	}
	@Test(timeOut = 2000, expectedExceptions=ThreadTimeoutException.class)
	public void bypassExceptionTest() throws Exception {
		Thread.sleep(5000);
		System.out.println("homePageTest");
	}
	@Test
	public void numberFormartExceptionTest() {
		String x = "1as4";
		int y = Integer.parseInt(x);
		System.out.println(y);
	}
	@Test(expectedExceptions=NumberFormatException.class)
	public void byPassnumberFormartExceptionTest() {
		String x = "1as4";
		int y = Integer.parseInt(x);
		System.out.println(y);
	}
}
