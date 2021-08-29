package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFooterlinks {
	static WebDriver driver;

	public static void main(String[] args) {
		
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.get("https://www.amazon.in/");
		
		BrowserUtil br=new BrowserUtil();
		driver=br.lunchBrowser("chrome");
		br.lunchUrl("https://www.amazon.in/");
		
		By footerLinks = By.xpath("//div[@class='navFooterVerticalRow navAccessibility']//a");
		
//		ElementUtil eleUtil=new ElementUtil(driver);
//		List<WebElement> footerList = eleUtil.getElements(footerLinks);
//		System.out.println(footerList.size());
//		
//		for (WebElement e : footerList) {
//			
//			System.out.println(e.getText());
//			
//		}
		
		List<String> footerTextList=getLinkTextList(footerLinks);
		//Validation Points:
		if (footerTextList.size()==22) {
			System.out.println("footer list count is correct");
		}
		
		if(footerTextList.contains("About Us")) {
			System.out.println("About Us is present");
			
		}
			

	}
	
	public static  List<WebElement> getElements(By locator) {
		return  driver.findElements(locator);
	}
	
	public static List<String> getLinkTextList(By locator) {
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

}
