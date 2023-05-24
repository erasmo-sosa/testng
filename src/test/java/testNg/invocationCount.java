package testNg;

import org.testng.annotations.Test;

public class invocationCount {
	@Test(invocationCount = 10)
	public void sum() {
		int a,b,c;
		a = 1;
		b = 2;
		c = a + b;
		System.out.println("sum is : " + c);
	}
}
