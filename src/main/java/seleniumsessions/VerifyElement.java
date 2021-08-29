package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyElement {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		By forgotPwd=By.linkText("Forgotten Password");
		
		
//		List<WebElement> forgotPwdList = driver.findElements(forgotPwd);
//		if(forgotPwdList.size()>0) {
//			System.out.println("link is present");
//		}

		if(isElementExist(forgotPwd)) {
			System.out.println("Pass");
		}
		
	}
	
	public static  List<WebElement> getElements(By locator) {
		return  driver.findElements(locator);
	}
	
	public static boolean isElementExist(By locator) {
		List<WebElement> listEle =getElements(locator);
		if(listEle.size()>0) {
			System.out.println("Element is present");
			return true;
		}
		System.out.println("Element is not present");
		return false;
		
	}

}
