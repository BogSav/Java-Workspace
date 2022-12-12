package packTest;

public class DemoInterfaceClass {
	
	public void initMethod(){
		ClassExample obj = new ClassExample();
		obj.displayIntExample1();
		obj.displayIntExample2();
		obj.displayIntExample3();
	}
}

// first interface
interface IntExample1{
	int WIDTH = 1;
	public void displayIntExample1();
	
	
}

// second interface
interface  IntExample2 {
	public void displayIntExample2();
}

//third interface
interface IntExample3 extends IntExample1, IntExample2{
	public void displayIntExample3();
}

class ClassExample implements IntExample3{
	@Override
	public void displayIntExample1(){
		System.out.println("displayClassExample1");
	}
	
	@Override
	public void displayIntExample2(){
		System.out.println("displayClassExample1");
	}
	
	@Override
	public void displayIntExample3(){
		System.out.println("displayClassExample1");
	}
}