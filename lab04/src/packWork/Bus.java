package packWork;

public class Bus extends Platform {
	private static int counter;
	int height;

	public int fieldPublic;

	static {
		System.out.println("static block init. Bus");
	}
	
	public Bus() {
		this(0, 0, 0);
		System.out.println("no parameter constructor Bus");
	}
	
	public Bus(int width, int length, int height) {
		super(width, length);
		//setWidth(width);
		//setLength(length);
		setHeight(height);
		counter++;
		System.out.println("3 parameters constructor Bus");
	}
	
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
	//	Bus.counter = counter;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height >= 0)
			this.height = height;
	}
	
	public void testFields() {
		//fieldPrivate = 0;	-> error
		fieldNoModifier = 0;
		fieldProtected = 0;
		fieldPublic = 0;	//this.fieldPublic = 0;				
		super.fieldPublic = 0;		
	}

	static {
		System.out.println("2nd static block init. Bus");
	}
	
}
