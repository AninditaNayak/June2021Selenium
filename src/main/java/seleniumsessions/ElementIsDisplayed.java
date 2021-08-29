package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementIsDisplayed {
     static WebDriver driver;
     
	
     //WebElement +isDisplayed()---->boolean(true/false)
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		 driver.get("https://demo.opencart.com/index.php?route=account/register");
//		 boolean flag=driver.findElement(By.name("search")).isDisplayed();
//		 System.out.println(flag);
		 
		By  searchField=By.name("search");
		By searchButton=By.xpath("//*[@id=\"search\"]/span/button");
		
		if (doIsDisplayed(searchField)) {
			doSendkeys(searchField, "MacBook");
			doClick(searchButton);			
			
		}
		 
		driver.findElement(By.name("search")).isEnabled();
		 
		}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static  void doSendkeys(By locator ,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public static boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}
}
