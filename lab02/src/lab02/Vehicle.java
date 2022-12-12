package lab02;

public class Vehicle {
	private static int counter;
	private int speed;

	public Vehicle(int speed) {
		counter++;
		setSpeed(speed);
	}

	public Vehicle() {
		this(0);
		//counter++;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed >= 0)
			this.speed = speed;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
	//	Vehicle.counter = counter;
	}


}
