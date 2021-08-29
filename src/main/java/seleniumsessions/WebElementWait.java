package seleniumsessions;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementWait {

	static WebDriver driver;
	public static void main(String[] args) {
		
		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId=By.id("input-email");
		By pwd=By.id("input-password");
		By login=By.xpath("//input[@value='Login']");
		
		By navigationLinks=By.xpath("//aside[@id='column-right']//a");
		
//		WebDriverWait wait=new WebDriverWait(driver,5);
//		WebElement email_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
			
		//email_ele.sendKeys("abc@gmail.com");
//		waitForElementVisibleUsingBy(emailId,5).sendKeys("abc@gmail.com");
//		driver.findElement(pwd).sendKeys("test123");
//		driver.findElement(login).click();
		
//		List<WebElement> navigationList = waitForElementsToBeVisible(navigationLinks,5);
//		for (WebElement e : navigationList) {
//			System.out.println(e.getText());
//			
//		}
		
		List<String> textList = getElementsTextList(navigationLinks,5);
		System.out.println(textList);
		if(textList.contains("Register")) {
			System.out.println("Register----Pass");
		}

	}
	
	
	
	public static  WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 * @param locator
	 * @param TimeOut
	 */
	public static WebElement waitForElementToBeClickable(By locator,int TimeOut) {
		WebDriverWait wait=new WebDriverWait(driver,TimeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void clickWhenReady(By locator,int TimeOut) {
		waitForElementToBeClickable(locator, TimeOut).click();
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.Visibility means that
	 *  the element is not only displayed but also has a height and width that isgreater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement  waitForElementVisibleUsingBy(By locator,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public static WebElement  waitForElementVisibleUsingWebElement(By locator,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
		
	}
	
	//we can apply wait for list of WebElements,(Footer links)
	
	public static List<WebElement> waitForElementsToBeVisible(By locator,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
	}
	
	public static List<String> getElementsTextList(By locator,int timeOut) {
		List<WebElement> eleList =waitForElementsToBeVisible(locator,timeOut);
		List<String> eleTextList =new ArrayList<String>();
		for (WebElement e : eleList) {
			eleTextList.add(e.getText());
		}
		
		return eleTextList;
		
	}
	
	
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

}
