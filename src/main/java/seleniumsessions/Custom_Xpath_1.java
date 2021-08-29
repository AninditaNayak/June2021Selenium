package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Xpath_1 {

	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//Xpath is a locator, not an Attribute, it is called address of WebElemnt, in the DOM
		//there is two types of Xpath
		//Absolute xpath--html/body/div/div[3]/div[4]/ul/li[3]/a
		//Relative xpath/custom path (by using htmltag and attributes+ functions+xpath axes)
		
		//Formula:
		//htmltag[@attribute='value']
		//input[@id='input-email']  (We can take any attribute)
		////input[@name='email']
		//****************************
		//If want to take two attribute , then both attribute is there
		
//      //htmltag[@attribute1='value' and @attribute2='value' ]
//      //input[@id='input-email' and @name='email']
		
// Note:		//or operator also we can use
//Note: can we use "" double quotes, yes we can use use but with escape character
		
		String xpath1="//input[@id=\"input-email\"]";
		
		String loginLink="Login";
		
		//Or:
	// //input[@type='text or @type='email']
		
		
		//***************Indexing concept
		
   //   //input[@class='form-control'] (here 2 matching coming and suppose no attribute is there)
		//we can use Indexing
		
//		(//input[@class='form-control'])[1] (if want to select 1st element, 
		//collect all the elements in the capture group then give index
		
// If dont want to give index we can use function position()
//  (//input[@class='form-control'])[position()=1]
//  (//input[@class='form-control'])[last()]	//If want to go to last element we can use last() function	
	
	//*******************************************
		
//    xpath with text(): //htmltag[text()='value']
		
//   //a (correct xpath, we can use findelements().tagname to find all the links
		
//   If want to click the specific link //a[text()='Login']
//    //span[text()=' sign up'] (here we have to pass exact text because space is there)
//    //h2[text()='Refreshing business software that your teams will love']
		
//*****************************************************	
		
//contains() : (for handling dynamic elements specific useful)
//htmltag[contains(@attr,'value')]
		
//Ex: id="input-email"
// //input[contains(@id,'email')]  (input tag contains email)
		
		//dynamic elements with dynamic attribute
		/*   <input id="firstname_123">
		     <input id="firstname_234">
		     <input id="firstname_456">  */
		
		//input[contains(@id,'firstname_')]
		
	//*************************************************	
//contains() with text():
		
//  //htmltag[text(),'value']
   //a[contains(text(),'Order')]
		
//contains() with one attribute and 2nd attribute without contains:
		
//  //htmltag[contains(@attr1,'value') and @attr2='value']
		
//  //input[contains(@id,'email') and @type='text' and contains(@name,'email')]
		

		//contains() with text() and Attribute:
	//htmltag[contains(text(),'value') and @attr='value']
		
	////contains() with text() and contains() with Attribute:

		
//**********************
//starts-with(): If want the text starts-with ( Refreshing business software that your teams will love)
		//h2[starts-with(text(),'Refreshing')]
		
		//dynamic elements with dynamic attribute
				/*   <input id="firstname_123">
				     <input id="firstname_234">
				     <input id="firstname_456">  */
		
		//input[starts-with(@id,'firstname_')]
		
//  //input[@type='text']---3
	//*[@type='text']---3    (What is the difference between these two)
//* means it will check in every element where type text and //input means it will go to input tag only and check type=text
// so performance wise tagname is better
		
		//with className method- can not use multiple classes together...But in xpath it is attribute, it will check complete value
		By b1=By.className("form-control private-form__control login-email");// Wrong one,we can use Unique class
		//we shouldnt have multiple classes with separated by Space, so this is wrong one
		//But below one correct
		
		By b2=By.xpath("//input[@class='form-control private-form__control login-email']");//correct
		By b3=By.cssSelector(".form-control.private-form__control.login-email");//correct
		
		By b4=By.className("login-email");//correct
		
		
	//Above which one correct?
		
		
//		By email=getBy("xpath", xpath1);
//		getElement(email).sendKeys("Ani");
		
		
		getElement("xpath", xpath1).sendKeys("Ani");
		getElement("linkText", loginLink).click();
		//getElement("hi", "Ani");

	}
	
	//you give me the string locator, then we will give the By locator
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
		
		}
	
	public static WebElement getElement(String locatorType,String locatorValue) {
		return driver.findElement(getBy( locatorType,locatorValue));
		
		}

	
	public static By getBy(String locatorType,String locatorValue) {
		By locator=null;
		switch (locatorType) {
		case "id":
			 locator=By.id(locatorValue);			
			break;
		case "name":
			 locator=By.name(locatorValue);			
			break;
		case "classname":
			 locator=By.className(locatorValue);			
			break;
		case "linkText":
			locator=By.linkText(locatorValue);			
			break;
		case "partialLinkText":
			 locator=By.partialLinkText(locatorValue);			
			break;
		case "tagName":
			 locator=By.tagName(locatorValue);			
			break;
		case "xpath":
		   locator=By.xpath(locatorValue);			
			break;
		case "cssSelector":
			locator=By.cssSelector(locatorValue);			
			break;
			

		default:
			System.out.println("Please pass the correct locator"+ locatorType);
			break;
		}
		return locator;
	}
}
