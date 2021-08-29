package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentOfJqueryDropDown {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		//Single Selection
		//driver.findElement(By.id("justAnotherInputBox")).click();
		
		By single_choices=By.cssSelector(".comboTreeItemTitle");
		By multi_choices=By.cssSelector(".comboTreeItemTitle");
		
		//MultiSelection with Cascade Option
		driver.findElement(By.id("justAnInputBox1")).click();
		Thread.sleep(2000);
		
		//selecAllChoice(single_choices,"choice 2");
        
		selecAllChoice(multi_choices,"choice 2");
		selecAllChoice(multi_choices,"choice 2");
	}
	
public static void selecAllChoice(By locator, String... value) {
		
		List<WebElement> choiceList = driver.findElements(locator);
		
		if(!value[0].equalsIgnoreCase("select_all")) {
		
		for (WebElement e : choiceList) {
			String text=e.getText();
			System.out.println(text);
			
			for(int j=0;j<value.length;j++ ) {
				if(text.equals(value[j])) {
					e.click();
					break;
				}
			}
			
		}
		}
		else {
			try {
			//all selection logic
			for(WebElement e:choiceList) {
				e.click();
			}
			}
		catch(Exception e) {
			
		}
	}}

}
