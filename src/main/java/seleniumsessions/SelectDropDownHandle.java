package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownHandle {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//here drop down having select html tag
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		
		//WebElement indus_ele = driver.findElement(industry);
		//WebElement country_ele = driver.findElement(country);
		
		//Select select=new Select(driver.findElement(industry));
//		Select select=new Select(indus_ele);
//		//select.selectByIndex(3);
//		//select.selectByVisibleText("Education");
//		select.selectByValue("media");
//		
//		
//		Select select_country=new Select(country_ele);
//		select_country.selectByVisibleText("India");
		
		doSelectByIndex(industry, 4);
		doSelectByIndex(country, 3);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectByIndex(By locator,int index) {
	    Select select=new Select(getElement(locator));
		select.selectByIndex(index);
		
	}
	
	public static void doSelectByVisibleText(By locator,String text ) {
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(text);
		
	}
	
	public static void doSelectByValue(By locator,String value ) {
		Select select=new Select(getElement(locator));
		select.selectByValue(value);
		
	}

}
