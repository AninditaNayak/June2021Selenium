package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;//the default value of driver is null now
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public  By getBy(String locatorType,String locatorValue) {
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
	

	public  WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public  WebElement getElement(String locatorType,String locatorValue) {
		return driver.findElement(getBy( locatorType,locatorValue));
		
		}
	
	public  List<WebElement> getElements(By locator) {
		return  driver.findElements(locator);
	}
	
	public  void doSendkeys(By locator ,String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public  String  doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	
	public  String  doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	
	public  boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public  boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}
	
	
	public  void clickOnElement(By locator,String value) {
		 List<WebElement> eleList = getElements(locator);
		 System.out.println(eleList.size());
		 for (WebElement e : eleList) {
			 if(e.getText().equals(value)) {
				 e.click();
				 break;
			  }					 
		 }		 
	 }
	
	public  List<String> getLinkTextList(By locator) {
		List<String> eleTextList = new ArrayList<String>();
		List<WebElement> eleList = getElements(locator);
		System.out.println("element count:"+ eleList.size());
		
		for(WebElement e:eleList) {
			String text=e.getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);
			}
				
		}
		return eleTextList;
		
	}
	
	public  boolean isElementExist(By locator) {
		List<WebElement> listEle =getElements(locator);
		if(listEle.size()>0) {
			System.out.println("Element is present");
			return true;
		}
		System.out.println("Element is not present");
		return false;
		
	}
	
	/***********************Drop Down Utils for (Select tag)************/
	 
	
	public  void doSelectByIndex(By locator,int index) {
	    Select select=new Select(getElement(locator));
		select.selectByIndex(index);
		
	}
	
	public  void doSelectByVisibleText(By locator,String text ) {
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(text);
		
	}
	
	public  void doSelectByValue(By locator,String value ) {
		Select select=new Select(getElement(locator));
		select.selectByValue(value);
		
	}
	
	public  List<String> getDropDownOptionsList(By locator) {
		List<String> optionsValList=new ArrayList<String>();
		Select select=new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());
		
		for (WebElement e : optionsList) {
			String text=e.getText();
			optionsValList.add(text);
			//System.out.println(text);
					
		}
		return optionsValList;
		
	}
	
	public  void selectDropDownValue(By locator,String value) {
		Select select=new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());
		
		for (WebElement e : optionsList) {
			String text=e.getText();
			if(text.equals(value)) {
				 e.click();
				 break;
			}
		}
		
	}
	 
public void clickDropDownvalue(By locator,String value) {
		
		List<WebElement> optionsList = getElements(locator);
		System.out.println(optionsList.size());
		
		for(WebElement e:optionsList) {
			String text=e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
			
		}
		
	}

/****************************User Action utils****************/

public  void twoLevelMenuHandle(By parentMenu, By childMenu) throws InterruptedException {
	Actions act=new Actions(driver);
	act.moveToElement(getElement(parentMenu)).perform();
	Thread.sleep(2000);
	getElement(childMenu).click();
	
}

public  void threeLevelMenuHandle(By parentMenu1, By parentMenu2, By childMenu) throws InterruptedException {
	Actions act=new Actions(driver);
	act.moveToElement(getElement(parentMenu1)).perform();
	Thread.sleep(2000);
	act.moveToElement(getElement(parentMenu2)).perform();
	Thread.sleep(2000);
	getElement(childMenu).click();
	
}

public  void doActionSendKeys(By locator,String value) {
	Actions act=new Actions(driver);
	act.sendKeys(getElement(locator), value).perform();
	
}

public  void doActionlick(By locator) {
	Actions act=new Actions(driver);
	act.click(getElement(locator)).perform();
	
}

/*******************Wait Utils****************/

public  Alert waitForAlert(int timeOut) {
	WebDriverWait wait =new WebDriverWait(driver,timeOut);
	return wait.until(ExpectedConditions.alertIsPresent());
	
}
   
   public  String getAlertText(int timeOut) {			
	String text=waitForAlert(timeOut).getText();
		acceptAlert(timeOut);
		return text;
		
	}

   
   public  void acceptAlert(int timeOut) {			
		 waitForAlert(timeOut).accept();
		
	}
   
   public  void dismissAlert(int timeOut) {			
		 waitForAlert(timeOut).dismiss();
		
	}
   
   public  void sendKeysOnAlert(int timeOut,String value) {			
		 waitForAlert(timeOut).sendKeys(value);
		
	}
   
   /************Wait Title utils************/
   
   
   public  String waitForTitleContains(String titlevalue,int timeOut) {
		
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		if(wait.until(ExpectedConditions.titleContains(titlevalue))){
			return driver.getTitle();
		}
		return null;
		
	}
	  
	  public  String waitFortitleIs(String exactTitle,int timeOut) {
			
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			if(wait.until(ExpectedConditions.titleIs(exactTitle))){
				return driver.getTitle();
			}
			return null;
			
		}
	  
	  public  String waitForUrlContains(String urlFraction,int timeOut) {
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			if(wait.until(ExpectedConditions.urlContains(urlFraction))){
				return driver.getCurrentUrl();
			}
			
			return null;
			
		}
		
		public  String waitForFullUrl(String urlValue,int timeOut) {
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			if(wait.until(ExpectedConditions.urlToBe(urlValue))){
				return driver.getCurrentUrl();
			}
			
			return null;
			
		}
		
		public  void waitForFrameAndSwitchToIt(String frameName,int timeOut) {
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
			
		}
		
		public  void waitForFrameAndSwitchToIt(int frameIndex,int timeOut) {
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
			
		}
		
		public  void waitForFrameAndSwitchToIt(By frameLocator,int timeOut) {
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
			
		}
		
		public  void waitForFrameAndSwitchToIt(WebElement frameElement,int timeOut) {
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
			
		}
		
		/**
		 * An expectation for checking an element is visible and enabled such that you can click it.
		 * @param locator
		 * @param TimeOut
		 */
		public  WebElement waitForElementToBeClickable(By locator,int TimeOut) {
			WebDriverWait wait=new WebDriverWait(driver,TimeOut);
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
		
		public  void clickWhenReady(By locator,int TimeOut) {
			waitForElementToBeClickable(locator, TimeOut).click();
		}
		
		
		/**
		 * An expectation for checking that an element is present on the DOM of a page and visible.Visibility means that
		 *  the element is not only displayed but also has a height and width that isgreater than 0.
		 * @param locator
		 * @param timeOut
		 * @return
		 */
		public  WebElement  waitForElementVisibleUsingBy(By locator,int timeOut) {
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
		}
		
		public  WebElement  waitForElementVisibleUsingWebElement(By locator,int timeOut) {
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
			
		}
		
		//we can apply wait for list of WebElements,(Footer links)
		
		public  List<WebElement> waitForElementsToBeVisible(By locator,int timeOut) {
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			
		}
		
		public  List<String> getElementsTextList(By locator,int timeOut) {
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

public  WebElement  waitForElementPresence(By locator,int timeOut) {
	WebDriverWait wait=new WebDriverWait(driver,timeOut);
	return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	
}

/**
 * 
 * @param locator
 * @param timeOut
 * @param intervalTime
 * @return
 */

public  WebElement  waitForElementPresence(By locator,int timeOut, int intervalTime) {
	WebDriverWait wait=new WebDriverWait(driver, timeOut, intervalTime);//we have another constructor with sleeptime in msec
	return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	
}

public  WebElement waitForElementWithFluentWait(By locator,int timeOut,long pollingTime) {
	Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			            .withTimeout(Duration.ofSeconds(timeOut))
			            .pollingEvery(Duration.ofMillis(pollingTime))
			            .ignoring(NoSuchElementException.class);
	
	return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			            
	
}

public  WebDriver waitForFrameWithFluentWait(By locator,int timeOut,long pollingTime) {
	Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			            .withTimeout(Duration.ofSeconds(timeOut))
			            .pollingEvery(Duration.ofMillis(pollingTime))
			            .ignoring(NoSuchElementException.class);
	
	 return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
			            
	
}

public  WebElement retryElements(By locator, int maxAttempts ) {
	WebElement element=null;
	int attempts=0;
	while(attempts<maxAttempts) {
		
		try {
		element=driver.findElement(locator);
		break;
		}
		catch(Exception e) {
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
