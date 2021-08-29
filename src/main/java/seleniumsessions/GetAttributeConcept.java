package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributeConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//WebElement + getArttribute("attr name")--> String
		
					
			WebDriverManager.chromedriver().setup();
			
		    driver=new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/register");
			
			By login=By.linkText("Login");
//			String hrefVal=driver.findElement(login).getAttribute("href");
//			System.out.println(hrefVal);
			
			if(doGetAttribute(login, "href").contains("login")) {
				System.out.println("login link having correct href value");
				
			}
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String  doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	

}
