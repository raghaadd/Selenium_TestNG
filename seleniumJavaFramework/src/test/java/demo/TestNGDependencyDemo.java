package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {
	
	@Test (dependsOnMethods = {"test2","test3"})
	public void test1() {
		System.out.println("inside Test 1");
		
	}
	
	@Test 
	public void test2() {
		System.out.println("inside Test 2");
		
	}
	
	@Test
	public void test3() {
		System.out.println("inside Test 3");
		
	}

}
