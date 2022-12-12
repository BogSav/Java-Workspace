package packWork;

public class Platform extends Vehicle {
	private static int counter;
	int width;
	int length;

	private int fieldPrivate;
	int fieldNoModifier;
	protected int fieldProtected;
	public int fieldPublic;

	private static int fieldStatic = initFieldStatic();
	
	static {
		System.out.println("static block init. Platform");
	}
	
	private static int fieldStaticAfter = initFieldStaticAfter();
	
	private int fieldNonStatic = initFieldNonStatic();
	
	{
		System.out.println("non-static block init. Platform");
	}
	
	private int fieldNonStaticAfter = initFieldNonStaticAfter();
	
	public Platform() {
		this(0, 0);
		System.out.println("no parameter constructor Platform");
	}
	
	private static int initFieldStatic() {
		System.out.println("initFieldStatic()");
		return 22;
	}

	private static int initFieldStaticAfter() {
		System.out.println("initFieldStaticAfter()");
		return 33;
	}

	private int initFieldNonStatic() {
		System.out.println("initFieldNonStatic()");
		return 44;
	}

	private int initFieldNonStaticAfter() {
		System.out.println("initFieldNonStaticAfter()");
		return 134;
	}

	public Platform(int width, int length) {
		setWidth(width);
		setLength(length);
		counter++;
		System.out.println("2 parameters constructor Platform");
	}
	
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
	//	Platform.counter = counter;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if (width >= 0)
			this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if (length >= 0)
			this.length = length;
	}

	static {
		System.out.println("2nd static block init. Platform");
	}
	
	public void testFields() {
		fieldPrivate = 0;
		fieldNoModifier = 0;
		fieldProtected = 0;
		fieldPublic = 0;		
	}

	{
		System.out.println("2nd non-static block init. Platform");
	}
	
}
