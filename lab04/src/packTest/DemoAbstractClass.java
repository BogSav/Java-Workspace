package packTest;

public class DemoAbstractClass {
	public void initMethod(){
		ClassExample obj = new ClassExample();
		obj.abstractDisplayClassExample();
		obj.displayClassExample1();
		obj.displayClassExample2();
		obj.displayClassExample3();
	}
}

// first class
class ClassExample1 {
	public void displayClassExample1(){
		System.out.println("display class 1");
	}
}

// second class
abstract class ClassExample2 extends ClassExample1{
	public void displayClassExample2(){
		System.out.println("display class 2");
	}
}

// third class
abstract class ClassExample3 extends ClassExample2 {
	public void displayClassExample3(){
		System.out.println("display class 3");
	}
	
	abstract public void abstractDisplayClassExample();
}

class ClassExample extends ClassExample3{
	
	@Override
	public void abstractDisplayClassExample(){
		System.out.println("absstractdisplayclass3example");
	}
}
