package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {
   static WebDriver driver;
   
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);
		
//		List<WebElement> choiceList = driver.findElements(By.cssSelector(".comboTreeItemTitle"));
//		
//		for (WebElement e : choiceList) {
//			String text=e.getText();
//			System.out.println(text);
//			if(text.equals("choice 6 2 3")) {
//				e.click();
//				break;
//			}
//			
//		}
		
		By choices=By.cssSelector(".comboTreeItemTitle");
		
		//TC 01: Single selection
		//selectChoice(choices, "choice 3");
		//selectChoice(choices, "choice 4");
		
		//But here if we want to select Multiple value ,we need to call that many times
		
		//TC 02: Multi selection
		
		//selectMultiChoice(choices,"choice 3");
		
		//selectMultiChoice(choices, "choice 3","choice 4","choice 6 2 3");
		
		
		//if want select 20 choices, then we have to give Comma separated so many times
		
		//TC 03: Multi Selection
		//selecAllChoice(choices,"choice 3");
		
		//selecAllChoice(choices,"choice 3","choice 4","choice 6 2 3");
		
		selecAllChoice(choices,"select_all");
		selecAllChoice(choices,"select_all");//deselection ,here we dont have any method for deselection,it is only available
		                                     // in select class, so againg if we call the method it will deselect
		
	}
	
	
	//Single Selection Utility Method
	
	public static void selectChoice(By locator, String value) {
  List<WebElement> choiceList = driver.findElements(locator);
		
		for (WebElement e : choiceList) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals(value)){   
				e.click();
				break;
			}
			
		}
	}
	
	//Mutliselection Utility Method,but this will work for single selection
	public static void selectMultiChoice(By locator, String... value) {
		  List<WebElement> choiceList = driver.findElements(locator);
				
				for (WebElement e : choiceList) {
					String text=e.getText();
					System.out.println(text);
//					if(text.equals(value)){  //here we comparing with single value, but value behaving as Value Array.we are doing wrong comparison
//						e.click();
//						break;
//					}
					
					for(int j=0;j<value.length;j++ ) {
						if(text.equals(value[j])) {
							e.click();
							break;
						}
					}
					
				}
			}
	
	//Select All choices, Customized version of above logic, which can take Single,Multi,and All
	
	/**
	 * 
	 * @param locator
	 * @param value
	 */
	
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