package packTest;

import packWork.Car;
import packWork.Vehicle;
import packWork.Platform;
import packWork.Bus;
import packWork.Buffer;
import packWork.CarConsumer;
import packWork.CarProducer;

public class MyMain {

	public static void main(String[] args) {
		/*lab03
		Vehicle myFirstVehicle = new Vehicle();
		System.out.println("myFirstVehicle.counter = " + Vehicle.getCounter());
		System.out.println("myFirstVehicle.speed = " + myFirstVehicle.getSpeed());
		
		Vehicle mySecondVehicle = new Vehicle(100);
		System.out.println("mySecondVehicle.counter = " + Vehicle.getCounter());
		System.out.println("mySecondVehicle.speed = " + mySecondVehicle.getSpeed());
		System.out.println("myFirstVehicle.counter = " + Vehicle.getCounter());
		System.out.println("myFirstVehicle.speed = " + myFirstVehicle.getSpeed());

		Car myFirstCar = new Car();
		System.out.println("myFirstCar.counter = " + Car.getCounter());
		myFirstCar.setSpeed(200);
		System.out.println("myFirstCar.speed = " + myFirstCar.getSpeed());
		System.out.println("myFirstVehicle.counter = " + Vehicle.getCounter());

		Car mySecondCar = new Car();
		System.out.println("mySecondCar.counter = " + Car.getCounter());
		System.out.println("myFirstCar.speed = " + mySecondCar.getSpeed());
		System.out.println("myFirstVehicle.counter = " + Vehicle.getCounter());

		//AbstractCar myFirstAbstractCar = new AbstractCar();

		System.out.println("Platform");
		System.out.println("Platform.counter = " + Platform.getCounter());
		System.out.println("Instance of Platform");
		Platform myPlatform = new Platform();
		//myPlatform.fieldPrivate = 0;	-> error
		//myPlatform.fieldNoModifier = 0;	-> error
		//myPlatform.fieldProtected = 0;	-> error
		myPlatform.fieldPublic = 0;		
		System.out.println("Bus");
		Bus myBus = new Bus();
		*/
		
		/*lab04
		DemoAbstractClass myDemoAbstractClass = new DemoAbstractClass();
		myDemoAbstractClass.testMethod();
		
		DemoInterfaceClass myDemoInterfaceClass = new DemoInterfaceClass();
		myDemoInterfaceClass.testMethod();
		
		DemoExceptionsClass myDemoExceptionsClass = new DemoExceptionsClass();
		myDemoExceptionsClass.testExceptionUnchecked();
		System.out.println("testExceptionUnchecked ended in main");
		myDemoExceptionsClass.testExceptionChecked();
		System.out.println("testExceptionChecked ended in main");
		*/
		
		/*ThreadsTest myThreadsTest = new ThreadsTest();
		myThreadsTest.testThreads();

		System.out.println("testThreads() ended in main()");*/
		
		Buffer b = new Buffer();
		CarProducer p1 = new CarProducer(b);
		CarConsumer c1 = new CarConsumer(b);
		p1.start();
		c1.start();
	}
}
