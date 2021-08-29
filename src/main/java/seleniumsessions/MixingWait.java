package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MixingWait {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//Implicit wait+ Explicit Wait
		//never use both the waits together
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId=By.id("input-email1");
//		By pwd=By.id("input-password");
//		By login=By.xpath("//input[@value='Login']");

		
		//Implicit Wait is Global wait,whatever elements coming after it will apply for all the elements
		//e1,e2,e3,e4..e10---20 sec
		
		//e2--Custom wait--WebDriverWait  (exp wait)(10 sec)
		
		//When selenium is interact with e2 element ,then what is the wait of e2--The cumulative wait is applied
		
		WebElement email = driver.findElement(emailId);//20 sec
		
		WebDriverWait wait=new WebDriverWait(driver,10,2000);//10 sec
		wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys("abc@gmail.com");
		
	}

}
