package lab02;

public abstract class AbstractCar extends Vehicle {
	private static int counter;	

	public AbstractCar() {
		counter++;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
	//	Car.counter = counter;
	}
	
	public abstract void displayColor();

}
