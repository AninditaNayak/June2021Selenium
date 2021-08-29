package testngsession;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReddifMailTest extends BaseTest {
	

	
	
//	@BeforeTest
//	public void setUp() {
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
//		
//	}
	//Deleting as We keep this one in BaseTest and same for AfterTest also
	
	@Test(priority=1)
	public void pageTitleTest() {
		//driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		String title=driver.getTitle();
		System.out.println("Page title is:"+title);
		Assert.assertEquals(title, "Rediffmail");
		
	}
	
	@Test(priority=2)
	public void apppageUrlTest() {
		String url=driver.getCurrentUrl();
		System.out.println("Page url:"+ url);
		Assert.assertTrue(url.contains("rediff"));
	}
	
	
	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
	
	
	//Now i want to Use AmazonTest,GoogleTest and RediffmailTest ,we need Test Runner, where we can use our all the Test cases and execute
   //We have to Create a testng.xml file
   //First we have to craete source fold, src/main/java and src/test/java, these are my Source folders
	//Right Click on Project--New--Sourcefolder--give name--src/test/resources 
	//And in src/test/resources , if we want any configuration files, we can store here
	//Then in the src/test/resources, we need to create the file, and give name testng.xml
	//Just like TestSuite, TestBlocks (we will write Test classes and inside we will write Methods)
	
	//in testng.xml --what is Vervose?
	//verbose="4">==Range is 1 to 10, 1 means Minimal Logs. 4 or 5 means more and more Selenium logs, 10 is more logs
	//Generally we will give 4
	//testng will give one html file also, Right Click on the Project-Then Refresh--then test-output file will generate
	//See index.html--rightclick--properties--copy the path
	//index.html file, read the testng-result.xml and craete the html report
	
	//testng-result.xml file give Overall result file, how many are pass and fail, total result
	//But testng-failed.xml will contain Only failed Test cases,(Here 2 TC failed)
	//Now i want rerun my failed Test cases? Can i execute my testng-failed.xml Only?
	//Yes, Only we can rerun testng-failed.xml for running the failed test cases.
	
	//If we delete the test-output folder it will not affect, but again if we run -refresh-it will generate the test-output
	//folder, if it will exist then it will Override.
	
	//We can define @parameters in suite level also, but we are doing in @test level
	
	//**************
	//For Parallel Execution , we need to maintain parallel="tests", so it will run parallel, at a time
	//browsers will Open, it is not like we can do parallel test only test level, we can do Class level and method level also
	//3 types of values we can pass, test, test methods,test class
	
	//thread-count="3", doesnt mean we have 3 test blocks ,thats why we are using 3 threads. If we have 3 test blocks, and
	//thread-count ="2", then 2 browser will lunch, if either of one thread free, it will pick the the Other test
	
	//if we dont want that perticular Test method will not execute, simply make  enabled=false. if again want to execute 
	// enabled=true, (Bydefault all the Test methods are enabled=true)
	
	
	
}
