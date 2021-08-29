package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		// get the count of all the links and print text of each link and (ignore the
		// blank text)
		// links start with a tag --<a>

		By links = By.tagName("a");

		// List<WebElement> linkList = driver.findElements(By.tagName("a"));
		List<WebElement> linkList = getElements(links);
		System.out.println("total links:" + linkList.size());

//		for (int i = 0; i < linkList.size(); i++) {
//			
//			String text =linkList.get(i).getText();
//			if (!text.isEmpty()) {
//				System.out.println(i + ":" +text);
//			}
//			
//		}

		// for each:
		int count = 0;
		for (WebElement e : linkList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				System.out.println(count + ":" + text);
				count++;
			}

		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
