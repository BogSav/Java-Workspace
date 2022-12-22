package packTest;

public class DemoInterfaceClass {
	public void testMethod() {
		DemoInterfaceClassExample myDemoInterfaceClassExample = new DemoInterfaceClassExample();
		myDemoInterfaceClassExample.displayDemoInterfaceClassExample();
		myDemoInterfaceClassExample.displayIntExample1();
		myDemoInterfaceClassExample.displayIntExample2();
		myDemoInterfaceClassExample.displayIntExample3();
		myDemoInterfaceClassExample.displayDefaultIntExample();
	}
}

//first interface
interface IntExample1 {
	int WIDTH = 1;
	
	public void displayIntExample1();
	
	public default void displayDefaultIntExample() {
		//WIDTH = 33;
		System.out.println("displayDefaultIntExample from IntExample1");
	}
}

//second interface
interface IntExample2 {
	public void displayIntExample2();

	public void displayIntExample2New();

	public default void displayDefaultIntExample() {
		System.out.println("displayDefaultIntExample from IntExample2");
	}
}

//third interface
interface IntExample3 extends IntExample1, IntExample2 {
	public void displayIntExample3();

	@Override
	default void displayDefaultIntExample() {
		IntExample1.super.displayDefaultIntExample();
		IntExample2.super.displayDefaultIntExample();
		System.out.println("displayDefaultIntExample form IntExample3");
	}
}

//DemoInterfaceClassExample
class DemoInterfaceClassExample implements IntExample3 {
	public void displayDemoInterfaceClassExample() {
		System.out.println("displayDemoInterfaceClassExample");
	}

	@Override
	public void displayIntExample3() {
		System.out.println("displayIntExample3");
	}

	@Override
	public void displayIntExample2() {
		System.out.println("displayIntExample2");
	}

	@Override
	public void displayIntExample1() {
		System.out.println("displayIntExample1");
	}

	@Override
	public void displayIntExample2New() {
		System.out.println("displayIntExample2New");
	}
	
}
