package packWork;

public class ThreadedImage extends Image implements ThreadFunctionality{
	protected Thread thread = null;
	protected Buffer buffer;
	
	// Constructorul ce primeste un buffer si dimensiunile imaginii
	public ThreadedImage(int width, int height, Buffer buffer){
		super(width, height);
		this.buffer = buffer;
	}
	
	// Constructorul ce primeste dimensiunile imaginii, un buffer si path-ul imaginii
	public ThreadedImage(String path, int width, int height, Buffer buffer) {
		super(path, width, height);
		this.buffer = buffer;
	}
	
	// Functie abstracta din ThreadFunctionality, utilizata la pornirea thread-ului
	@Override
	public void start(){
		thread.start();
	}
	
	// Functie abstracta din ThreadFunctionality, utilizata penru a bloca thread-ul un anumit numar de milisecunde
	@Override
	public void sleep(int duration){
		try{
			thread.sleep(duration);
		}
		catch (InterruptedException e){
			
		}
	}
}
