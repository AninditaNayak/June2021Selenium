package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickMenuHandle { 
	
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		// Right click---Context menu click
		
//		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
//		Actions act=new Actions(driver);
//		act.contextClick(rightClickEle).perform();
//		
//		List<WebElement> itemList=driver.findElements(By.xpath("//li[contains(@class,'context-menu-item context-menu-icon')]/span"));
//		
//		System.out.println(itemList.size());
//		for (WebElement e : itemList) {
//			String text=e.getText();
//			System.out.println(text);
//			
//			if(text.equals("Copy")) {
//				e.click();
//				break;
//			}
//			
//			
//		}
		
		By rightClickEle=By .xpath("//span[text()='right click me']");
		By itemList=By.xpath("//li[contains(@class,'context-menu-item context-menu-icon')]/span");
		
		rightClickMenu(rightClickEle, itemList, "Copy");
      
	}
	
	//Create a Utility  function
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void rightClickMenu(By locator,By locator1, String value) {
		Actions act=new Actions(driver);
	    act.contextClick(getElement(locator)).perform();
	    List<WebElement> itemList=driver.findElements(locator1);
		System.out.println(itemList.size());
		for (WebElement e : itemList) {
			String text=e.getText();
			System.out.println(text);
			
			if(text.equals(value)) {
				e.click();
				break;
		
	}
	

}
	}
	
}
