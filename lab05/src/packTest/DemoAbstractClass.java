package packTest;

public class DemoAbstractClass {
	public void testMethod() {
		DemoAbstractClassExample myDemoAbstractClassExample = new DemoAbstractClassExample();
		myDemoAbstractClassExample.displayDemoAbstractClassExample();
		myDemoAbstractClassExample.displayAbstractClassExample2();
		myDemoAbstractClassExample.displayClassExample1();
		myDemoAbstractClassExample.displayClassExample2();
		myDemoAbstractClassExample.displayClassExample3();
		myDemoAbstractClassExample.displayAbstractClassExample2New();
		myDemoAbstractClassExample.displayClassExample1New();
	}
}

//first class
class ClassExample1 {
	int width;
	static final int HEIGHT = 0;
	
	public void displayClassExample1() {
		width = 33;
		//HEIGHT = 33;
		System.out.println("displayClassExample1");
	}

	public void displayClassExample1New() {
		System.out.println("displayClassExample1New");
	}

}

//second class
abstract class ClassExample2 extends ClassExample1 {
	public void displayClassExample2() {
		System.out.println("displayClassExample2");
	}
	
	public abstract void displayAbstractClassExample2();
		
	public abstract void displayAbstractClassExample2New();

}


//third class
abstract class ClassExample3 extends ClassExample2 {
	public void displayClassExample3() {
		System.out.println("displayClassExample3");
	}
}

//DemoAbstractClassExample
class DemoAbstractClassExample extends ClassExample3 {
	public void displayDemoAbstractClassExample() {
		System.out.println("displayDemoAbstractClassExample");
	}

	@Override
	public void displayAbstractClassExample2() {
		System.out.println("displayAbstractClassExample2");
	}

	@Override
	public void displayAbstractClassExample2New() {
		System.out.println("displayAbstractClassExample2New");
	}
}

