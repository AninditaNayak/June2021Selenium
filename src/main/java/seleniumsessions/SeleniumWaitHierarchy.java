package seleniumsessions;

public class SeleniumWaitHierarchy {

	public static void main(String[] args) {
		
		//WebDriverWait is class--Extending FluentWait class--Implementing   Wait  interface--has untill() method
		//untill method has no body, because it is available in wait interface
		//untill() method implementded by FluentWait
		//There is no difference between WebDriverWait and FluentWait.
		//All the methods available in FluentWait, present in WebDriverWait.
		
		//How many methods are there in WebDriverWait class?
		//Only  1  method timeOutException()  is Overridden
		//No individual methods

	}

}
