package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		Actions act=new Actions(driver);
		act
		.clickAndHold(sourceEle).moveToElement(targetEle)
		.release(targetEle).build().perform();// Here multiple AActions are there so we should use builda() and perform()
		                                     //Only perform() it will not work
		              //or we can do also
		//act.dragAndDrop(sourceEle, targetEle).perform();// this method we can also use
		
		                                            

	}

}
