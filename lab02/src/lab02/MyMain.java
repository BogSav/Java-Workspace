package lab02;

public class MyMain {

	public static void main(String[] args) {
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
	}

}
