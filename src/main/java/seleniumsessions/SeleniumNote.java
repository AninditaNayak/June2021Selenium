package seleniumsessions;

public class SeleniumNote {

	public static void main(String[] args) {
		
	//Selenium:
	//1.Selenium IDE:Record and Play Tool
	//2.Selenium RC:Selenium 1-Java/JS/Ruby/Phython
	//WebDriver+Selenium RC->3.Selenium WebDriver-->Multi Language support
	//Selenium Grid:is used to run your test cases on Remote machine/docker hub/normal grid/Vendor cloud
	//WebDriver:
	//1.Language support:Java/c#/Phython/js/ruby/php
	//2.Multi OS/Platform:windows/mac/linux
	//3.Free and Open source: Free means no need to Pay anything and Opensource means we can access the source code
	//4.It supports different third party tools:Maven,testng,docker,APIs,reports,log4j,POI
	//It automates Only browser/web application
	//It is a web automation library/tool/Framework(It is Only an Automation tool, not an Testing tool)
	//We will configure it, not install it
	//It supports Multi browsers:Chrome/Firefox/safari/edge/Opera
	//It can be run on different cloud mchines/Vendors:AWS/GCP/Local cloud/Docker Grid/Browser Stack/SauceLabs/Lambda Test
	//TestNG/Junit+Selenium ==>to write test cases
	//Selenium does not Provide any reporting library/api:we have to use 3rd party libs:Extent,Allure,testng reports
	//Selenium can do some  very Complex user actions:pop ups,browser window pop ups,frames,auth pop
	//Can not automate any Desktop application/Mobile app
	//can be used for Web scrapping also(means fetch the data)
	//It supports Multiple locators(Xpath/css,id,name,classname,tagname,links)
	//does not provide any api or any libs to get the test data from excel/csv/xml/json (third party tll we have to integrate to get the data)
	//backend testing and database testing we cant do in selenium,whatever we see in WebPages only and Only we Automate.
		
	
   //Selenium+Java
   //Jars+ Maven Dependency
   //Eclipse->Maven->pom.xml->add the selenium WD dependency
		
  //2.We have to download the binary file, chromedrive.exe ,geckodriver.exe file
  //we have write the script in java.. can it will directly contact with browser,no through Selenium server it will 
 // contact with browser
		
//Who is starting selenium server: it will started by these binary files like chromedriver.exe,geckodrive.exe..
//these binary files provided by respective vendors
		
	//---------------------------------------	
	//WebDriver API Architecture
	
	//SearchContext is Interface (two methods findElement and findElements method is present)
	//WebDriver (I) ,here above two methods are Overridden , in WebDriver so many methods are there but without Method body
	//because Webdriver is an Interface.
	//Now RemoteWebDriver Class implements WebDriver Interface, so all the methods are Overridden with Method body.
	//Now chromedrive,geckodriver, safaridriver..class extending Remote webdriver.Only Chromedriver extends Chromium driver
	//and then Chromium driver class extends RemoteWebdriver.
	//All the driver classes we dont have any individual methods.
		
	//Want to Lunch Google chrome, so what are different combinations
		
	//1.When we have Only One browser specific, no cross browser then we can use only One browser
		//Chrome
	
	//-------------------------------------------QuitVsClose (08 July)
		
		//WD Client Server Architecture
		//(Client) Script you are written Like Lunch browser,Lunch url,Get title..
		//Then we have Server where it may be chromedriver,geckodriver..
		//As soon as we write WD driver=new ChromeDriver()-->the request will go to the server ,the server will process the 
		//request and it will lunch prticular browser
		//what will happen when Lunch the Url,Client will send the request to server ,a session ID will create between 
		//Client and Server, and same session id will remain same through out the same session
		//
		
	//------------------------------(08 July)
	//WebDriverManager--It will take care of our executable files
	//Go to WDM github page, it is also called bonigarcia 
		
	  /*<dependency>
	    <groupId>io.github.bonigarcia</groupId>
	    <artifactId>webdrivermanager</artifactId>
	    <version>4.4.3</version>
	    <scope>test</scope> (Remove scope here, it will show we can use only in src/test/java but i want to use in main also
	                        (so remove scope)    
	</dependency> */
		
		//---------------------(09 July)URL
		
//		    https://demo.opencart.com/index.php?route=account/login
//			https://www.orangehrm.com/orangehrm-30-day-trial/
//			http://automationpractice.com/index.php
//			https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
//          http://automationpractice.com/index.php
//          https://mail.rediff.com/cgi-bin/login.cgi(JS popup)
//          https://the-internet.herokuapp.com/basic_auth  (Auth popup)
//          https://app.hubspot.com/
		
		//******************************************
		//Every page is having DOM structure (Document Object Modal)
		//When you load any page, DOM is coming First, or Page is Coming First
		//First DOM will update, then from DOM perticular page will show,this is called DOM parsing 
		//Present inside the DOM, will not gurantee that it will show in the WebPage (Every browser having separate DOM structure)
		//Everything in the Page called WebElements
		//After < called html tag , we see some attributes it will be there in key value pair
		
		
		//Google search single click xpath
		//Move to Element handle Spice jet nots able to click
		
		//https://github.com/SeleniumHQ/selenium

		
		
		
		

	}

}
