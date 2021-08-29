package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSPopupHandle {

	static WebDriver driver;
	public static void main(String[] args) {
		
		//JS--alert--alert() method,JS popup
		//the problem with this popup is ,i cant inspect this popup, they are coming because of alert() method, 
		//so message will be there, with OK cancel or yes no button
		

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		System.out.println(text);
		
		alert.accept();//accept the alert,it will click on Ok button
		//alert.dismiss();//i dont want to accept the alert
		
		//One more method is there 
		//alert.sendKeys("testing");//to pass the value
		
		//What do you mean by Alert popup or JS popup
		//In the Selenium we have Alert Api, we switch to that perticular alert , using driver.swithchTo().alert
		//we have 4 methods,getText(),acept(),dismiss(),sendkeys()
		driver.switchTo().defaultContent();//u come back to the main page and continue your work
		
		
	}

}
