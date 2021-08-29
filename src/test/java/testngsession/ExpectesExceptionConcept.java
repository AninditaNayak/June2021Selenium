package testngsession;

import org.testng.annotations.Test;

public class ExpectesExceptionConcept {
	
	String name="testing";
	
	@Test(expectedExceptions= {ArithmeticException.class,NullPointerException.class})
	public void homePageTest() {
    	System.out.println("homePageTest");
    	int i=9/0;// here we will get java.lang.ArithmeticException: / by zero
    	
    	ExpectesExceptionConcept obj=null;
    	System.out.println(obj.name);//here we will get NullPointerException and test will fail,but we are expecting Arithmatic,
    	                             //At line no 12. first we will get Arithmatic exception,and Program will terminate
    	                            // we can give class of array
    	
    	
	}
	//What do you mean by  expectedExceptions? and How we will ignore the Exception?
	//We will not use ,this is for interview purpose.
	
	//but if we will give (expectedExceptions=ArithmeticException.class), it will pass
	//This is just a hack, we should not use this 
	

}
