package testngsession;

import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;

public class TestNGBasics {
	
	//Note: (Test Next Generation) Open SourceTstNG is Unit testing framework, TstNG help to maintain the test cases, what ever we are writing
	//1. if we are excuting 100 Test cases, it will give html report , how many are pass and how many are fail
	// 2.TestNG will provide very good library for Assertion means, validation( Hard Assert, and Soft Assert)
	//3.Call ur Functions, functions should not Validate,calling this Function from TestNG class,its test client 
	// responsibility to Provide Assertion
	//4. It provide the Priortization of Test cases also.
	//5.Provide number of Annotation also.  (Pre Annotation+Test( here we will write Assertion)+Post Annotaion
	//6.Data Provider
	//If we are working in Java then we are using Unit Testing Framework TestNG and Junit we are Using
	//For Phython-PyTest
	//For PHP-PHP Unit
	//C# NUnit
	//Java Script-Jasmin and Mocha(Cypress internally using Mocha only)
	//Install Test NG:(We need both)
	//1.If you are usingg Maven Framework, add Dependency in POM.xml
	//2.We have to Install  TestNG plugin in Eclipse (To Run the Test cases we need this Plugin)
	
	//-------------
	//Wehen ever we are writing any Manual Test Cases 3 things we have to remember
	//precondition
	//Test Cases--Test Steps+Assertion(Act vs Exp)
	//post condition
	
	//Every Annotation associated with the Method
	//It is not compulsory to use @BeforeSuite,@BeforeTest,@BeforeClass..
	//@Test will be executed on the basis of Alphabatic Order(here addtocart,homepage,payment page)
	
	
	@BeforeSuite
	public void DBConnection() {
		System.out.println("BS---DB Connection");
	}
	
	@BeforeTest
	
	public void CreateUser() {
		System.out.println("BT---Create user");
	}
	
	@BeforeClass
	public void LunchBrowser() {
		System.out.println("BC---lunch browser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("BM---login");
	}
	
	@Test
	public void homePageTest() {
		System.out.println("homePageTest");
	}
	@Test
	public void addToCartPageTest() {
		System.out.println("addToCartPageTest");
	}
	@Test
	public void paymentPageTest() {
		System.out.println("paymentPageTest");
	}
	
	
	@AfterMethod
	public void logout() {
		System.out.println("AM---logout");
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC---closeBrowser");
	}
	@AfterTest	
	public void deleteUser() {
		System.out.println("AT---deleteUser");
	}	
	
	@AfterSuite
	
	public void disconnectDB() {
		System.out.println("AS---disconnectDB");
	}

}
