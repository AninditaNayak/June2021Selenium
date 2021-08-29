package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
	
		//2.dynamic wait-->10sec:if the element found in 5 sec then (rest 5 sec will ignored)
		//a.implicit wait
		//b.explicitwait--again 2 parts WebDriverwait (c)--internally extending FluentWait(C) -->implementing Wait(Interface)

		//it is a custom wait,--> not Global wait-->you can define your own wait for a specific element
		//can be applied for wbebelements and nonwebelements(url,title,popup,alert..)
		
		//WebDriverWait is a class ,we need to create Object of the WebDriverWait class and it dont have any default
		//constructor, have to pass 2 parameter  driver and Time (total no of seconds u need to apply)
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId=By.id("input-email1");
		By pwd=By.id("input-password");
		By login=By.xpath("//input[@value='Login']");
		
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys("abc@gmail.com");//this method says we have give the by locator
		
		waitForElementPresence(emailId, 10,2000).sendKeys("abc@gmail.com");
		driver.findElement(pwd).sendKeys("test123");
		driver.findElement(login).click();
	}
	
	//we have to create the wait utilities
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does notnecessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	
	public static WebElement  waitForElementPresence(By locator,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public static WebElement  waitForElementPresence(By locator,int timeOut, int intervalTime) {
		WebDriverWait wait=new WebDriverWait(driver, timeOut, intervalTime);//we have another constructor with sleeptime in msec
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}

}

//NOTE: org.openqa.selenium.TimeoutException: Expected condition failed: waiting for presence of element located by: 
//By.id: input-email1 (tried for 10 second(s) with 500 milliseconds interval)
//For Implicit wait also we are getting this

//tried for 10 second(s) with 500 milliseconds interval: what the meaning of this?
   //The default polling time is 500 mili seconds in Selenium for both ImplicitWait and WebDriverWait.
   //wait we have given 10 sec , just to check element is there or not( 0.5 sec) again after 0.5 sec will check 
//Can we Customize interval time,if we dont want to wait for 500 mili second, can we Overload the interval time?

//yes ,org.openqa.selenium.TimeoutException: Expected condition failed: waiting for presence of element located by: 
//By.id: input-email1 (tried for 10 second(s) with 2000 milliseconds interval)
//But not always needded, when needed we can do



