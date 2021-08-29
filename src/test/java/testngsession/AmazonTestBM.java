package testngsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestBM {
	
WebDriver driver;
	
//If we are using @BeforeMethod for every Test method , @BeforeMethod is executing,here Url opening three times and closing

//In @Before Test--My Test Cases are there and @Aftertest, in between the Test cases if my (Ex TC 10 -application crashed)
//There is no mechanism in between TC 11 to TC 50 to execute them, Onlt 10 Test Cases are there

//But in  BeforeMethd-TC1-AfterMethod, BeforeMethd-TC2-AfterMethod,..here in TC 10 my app crashed
//But in TC 11 , mechanism is there the application will reopen and rest Tc will execute
//which one is better now? 2nd approach is good,because every Test case is getting its own chance
//Disadvantage: is Time consuming
//Only for Sanity TC we can use @BeforeTest approach
//But for Regression suite we can use @BeforeMethod approach

	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
	}
	
	@Test
	public void pageTitleTest() {
		String title=driver.getTitle();
		System.out.println("Page title is:"+title);
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
	}
	
	@Test
	public void apppageUrlTest() {
		String url=driver.getCurrentUrl();
		System.out.println("Page url:"+ url);
		Assert.assertTrue(url.contains("amazon"));
	}
	
	@Test
	public void searchBoxTest() {
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
