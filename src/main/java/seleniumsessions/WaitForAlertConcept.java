package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlertConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//driver.findElement(By.name("proceed")).click();
		
		//without clicking if switch to alert, we will get NoAlertPresentException thrown by Selenium
		/*WebDriverWait wait =new WebDriverWait(driver,10);
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());//this is equivalent to driver.switchTo().alert();
		
		//driver.switchTo().alert();
		
		System.out.println(alert.getText());
		alert.accept(); */
		
		//String text=getAlertText(5);
		//System.out.println(text);
		//acceptAlert(5);//two way we can handle ,either we call acceptAlert method or inside getAlertText we can call the method

		
		//titles:  (same thing we can do it for Titles, sometimes Title will come after 2 or 5 sec, we want to wait for that Title)
		
		
		
		/*    WebDriverWait wait=new WebDriverWait(driver,5);
		if(wait.until(ExpectedConditions.titleContains("Login"))) {
			System.out.println(driver.getTitle());
		}  */
		
//		String title=waitForTitleContains("Login",5);
//		System.out.println(title);
		
		
		//Url:
		
		driver.findElement(By.linkText("Register")).click();
		WebDriverWait wait=new WebDriverWait(driver,5);
		if(wait.until(ExpectedConditions.urlContains("register"))){
			System.out.println(driver.getCurrentUrl());
		}
		
	}
	
	//Url Generic function
	
	public static String waitForUrlContains(String urlFraction,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		if(wait.until(ExpectedConditions.urlContains(urlFraction))){
			return driver.getCurrentUrl();
		}
		
		return null;
		
	}
	
	public static String waitForFullUrl(String urlValue,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		if(wait.until(ExpectedConditions.urlToBe(urlValue))){
			return driver.getCurrentUrl();
		}
		
		return null;
		
	}
	
	
	
	  public static String waitForTitleContains(String titlevalue,int timeOut) {
		
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		if(wait.until(ExpectedConditions.titleContains(titlevalue))){
			return driver.getTitle();
		}
		return null;
		
	}
	  
	  public static String waitFortitleIs(String exactTitle,int timeOut) {
			
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			if(wait.until(ExpectedConditions.titleIs(exactTitle))){
				return driver.getTitle();
			}
			return null;
			
		}
	
	  
	  /******************Alert Util********/
	  
	   public static Alert waitForAlert(int timeOut) {
		WebDriverWait wait =new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
		
	}
	   
	   public static String getAlertText(int timeOut) {			
		String text=waitForAlert(timeOut).getText();
			acceptAlert(timeOut);
			return text;
			
		}

	   
	   public static void acceptAlert(int timeOut) {			
			 waitForAlert(timeOut).accept();
			
		}
	   
	   public static void dismissAlert(int timeOut) {			
			 waitForAlert(timeOut).dismiss();
			
		}
	   
	   public static void sendKeysOnAlert(int timeOut,String value) {			
			 waitForAlert(timeOut).sendKeys(value);
			
		}
}
