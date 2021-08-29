package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoOpenCart {

	public static void main(String[] args) {
		
		String browser="chrome";
		
		BrowserUtil brUtil=new BrowserUtil();
		WebDriver driver =brUtil.lunchBrowser(browser);
		brUtil.lunchUrl("https://demo.opencart.com/index.php?route=account/register");
		
		System.out.println(brUtil.getPageTitle());
		
		//Locators:
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By phone = By.id("input-telephone");
		By pwd = By.id("input-password");
		By cpwd = By.id("input-confirm");
		
		
		ElementUtil eleUtil=new ElementUtil(driver);
		eleUtil.doSendkeys(firstName, "Ani");
		eleUtil.doSendkeys(lastName, "Nayak");
		eleUtil.doSendkeys(email, "Ani@gmail.com");
		eleUtil.doSendkeys(phone, "134567457");
		eleUtil.doSendkeys(pwd, "Ani@123");
		eleUtil.doSendkeys(cpwd, "Ani@123");
		

	}

}
