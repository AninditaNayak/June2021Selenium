package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//Wait in Selenium:Synchronization
		//can be applied for WebElements and non webelements (url,title,alert, popup)
		//2Types:
		//1.static wait-->Thread.sleep(10000)--It will pause the script for 10 sec
		//2.dynamic wait-->10sec:if the element found in 5 sec then (rest 5 sec will ignored)
		//a.implicit wait
		//b.explicitwait--again 2 parts WebDriverwait (c)--internally extending FluentWait(C) -->implementing Wait(Interface)
		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//implicit wait--dynamic wait
		//its only applicable for WebElements,it cant be applied for nonwedelements
		//it is a global wait, it is applied with driver and then will be applicable to all the Upcoming WebElements
		
		//e1-->5 sec to visible on the page
		//imp wait-->driver--Time Out --10 sec
		//If e1 visible in 5 sec-->rest of the 5 sec will be ignored
		//If after 10 sec e1 will not visible,then Selenium will thrw nosuchElementexception
		//But it is a Global wait
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		WebElement emailId=driver.findElement(By.id("input-email"));// 10 sec will apply
		WebElement pwd=driver.findElement(By.id("input-password"));// 10 sec will apply--0 sec , but why it will simply 
		                                                           //call the implicit wait
		//why i want implicit wait in pwd and login,if it is already available in the page, if it is 0 sec also, but it will check 
		//implicit wait mechanism( First Problem)
		WebElement login = driver.findElement(By.xpath("//input[@value='Login']")); // 10 sec will apply
		//it will apply for emailid, pwd and login also, emailId ok, but it is not required that 
		//pwd and for Login also it will come in 5 sec / it i not required
		
		emailId.sendKeys("abc@gmail.com");
		pwd.sendKeys("abc1234");
		login.click();
		
		//for home page --5sec , can we override the implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		//what i the implicit wait for e4,e5,e6
		
		//logout:
		//login page: again 10 sec, again we have to Override the implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//register page: again 15 sec,
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

		//forgot pwd page: required 0 sec,i have to nullify my implicit wait
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		
		//2ns problem, for every page we have to  Override the implicit wait
		
		//Note: we never use Implicit wait at all
		
		//Explicit wait: there is no keyword like Explicit wait, it in form WebDriver wait and Fluentwait
		
	}
	

}
