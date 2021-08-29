package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
	    driver=new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		//Create a webelement + perform action(Click,sendkeys,getText,isDisplayed)
		//Locators:
		//1.id   (I)
		
		//1st
		
		//driver.findElement(By.id("Form_submitForm_FirstName")).sendKeys("Ani");//by is class in Java ,and then there 
		                                                          //are 8 locators ,id is a Static method (so calling by Class name
		                             
		//driver.findElement(By.id("Form_submitForm_LastName")).sendKeys("Nayak");
		
		//Is this a right way , if again and again write same
		
		//2nd  (Using driver.findElement we are hitting the server every time)
		
//		WebElement firstName = driver.findElement(By.id("Form_submitForm_FirstName"));
//		WebElement lastName =driver.findElement(By.id("Form_submitForm_LastName"));
//	    
//		firstName.sendKeys("Ani");
//		lastName.sendKeys("Nayak");
		
		//3rd :By locator (With this approach we are not hitting the server, we are creating by By class, then when needed
		// we are hitting server using driver.findelement and hitting the server
		
//		By firstName = By.id("Form_submitForm_FirstName");
//		By lastName = By.id("Form_submitForm_LastName");
//		
//		WebElement fn_ele = driver.findElement(firstName);
//		WebElement ln_ele = driver.findElement(lastName);
//		
//		fn_ele.sendKeys("Ani");
//		ln_ele.sendKeys("Nayak");
		
	//4th: generic method
//		By firstName = By.id("Form_submitForm_FirstName");
//		By lastName = By.id("Form_submitForm_LastName");
//		
//		getElement(firstName).sendKeys("Ani");
//		getElement(lastName).sendKeys("Nayak");
		
		
	//5th: Generic method for Actions
//		
//		By firstName = By.id("Form_submitForm_FirstName");
//		By lastName = By.id("Form_submitForm_LastName");
//		
//		doSendkeys(firstName, "Ani");
//		doSendkeys(lastName, "Nayak");
		
	//6th:Create a new ElementUtil class with generic functions
		
//		By firstName = By.id("Form_submitForm_FirstName");
//		By lastName = By.id("Form_submitForm_LastName");
//		
		ElementUtil eleUtil=new ElementUtil(driver);
//		eleUtil.doSendkeys(firstName, "Ani");
//		eleUtil.doSendkeys(lastName, "Nayak");
		
		
	//2.name (when both id and name will be there , Prefer ID ,ID cann't be duplicate but name canbe duplicate)	
	//(II)
		
//		By fn = By.name("FirstName");
//		eleUtil.doSendkeys(fn, "Ani");
	
	
  //3.className: can be duplicate for Multiple elements, can be used only when it is unique
	
 //4.linkText: Only for links (The html tag of always link is a)
	  //By login=By.linkText("Login");
	  //driver.findElement(login).click();
	  //doClick(login);
	  
	  
//5.partial link text: Only for links
//Forgotten username
//Forgotten pwd
	  
//	  By forgotpwd = By.partialLinkText("Forgotten");
//	  doClick(forgotpwd);
		
	
//6.xpath: is a locator, address of the element in DOM  (III)
//Its not an attribute
		
//		By fn = By.xpath("//*[@id=\"input-firstname\"]");
//		doSendkeys(fn, "testing");
		
		
//7.css selector: is a locator,	but Its not an attribute (https://demo.opencart.com/index.php?route=account/register)
//(better performance) (IV)
		
//	By ln=By.cssSelector("#input-lastname");
//	doSendkeys(ln, "Selenium");
		
		
//8.tagname: HTML tag	(https://www.freshworks.com/)
		
	By header =By.tagName("h2");
	//String text=driver.findElement(header).getText();
	String text=doGetText(header);
	System.out.println(text);
	
		
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendkeys(By locator ,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
		
	}
	
	public static String  doGetText(By locator) {
		return getElement(locator).getText();
	}
	
}
	


