package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//Use only sleep();
		//we dont need to use any wait provided by selenium,only Thread.sleep()
		//Programatically we can use Thread.sleep()
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId=By.id("input-email1");
		
		retryElements(emailId).sendKeys("abc@gmail.com");

	}
	
	public static WebElement retryElements(By locator ) {
		WebElement element=null;
		int attempts=0;
		while(attempts<20) {
			
			try {
			element=driver.findElement(locator);
			break;
			}
			catch(NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					
					e1.printStackTrace();
				}
				
				System.out.println("elements is not found in attempt:"+ (attempts+1));
				
			}
			
			attempts++;
		}
		
		return element;
		
	}

}
