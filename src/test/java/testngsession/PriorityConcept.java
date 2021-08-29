package testngsession;

import org.testng.annotations.Test;

public class PriorityConcept {
	
	@Test(priority=3)
	
	public void a_test() {
		System.out.println("a test");
	}
	
@Test(priority=1)
	
	public void b_test() {
		System.out.println("b test");
	}

@Test(priority=5)

public void c_test() {
	System.out.println("c test");
}

@Test(priority=2)

public void d_test() {
	System.out.println("d test");
}

@Test(priority=4)

public void e_test() {
	System.out.println("e test");
}

//First if we run the TC in TestNG it will execute in alphabatic order(a b c d e)
//If want the Priority oder of execution,then we have to give (priority=1,priority=2..)
//Can we have the priority=0, yes it will execute first, then 1, 2..
//Can we have the priority=-1, yes it will execute first,, -1, 0, 1,..
//Can we have the priority=-5, yes it will execute first,, -5,-1, 0, 1,..

//Practically we can't use -ve Priority and 0 Priority

//Note: If in test method, some are having priority and and Some are not having priority, which will execute first?
//Priority based or NonPriority based?
//Ans:NonPriority based TC execute First in Alphabatical order ,and then Priority execute 
//Is it really compulsory to maintain Priority? No it is not mandatory What is Best Practise?


}


