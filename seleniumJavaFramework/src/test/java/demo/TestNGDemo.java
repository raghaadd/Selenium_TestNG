package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGDemo {
	
	@Ignore
	@Test 
	public void test1() {
		System.out.println("inside Test 1");
		
	}
	@Test 
	public void test2() {
		System.out.println("inside Test 2");
		
	}

}
