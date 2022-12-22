// Sava Nicolae Bogdan 331AB

package packWork;

public class CarConsumer extends Car implements Runnable{
	private Buffer buffer;
	private Thread thread = null;
	
	// Constructorul folosit pentru instantierea bufferului si pentru crearea unui nou thread
	public CarConsumer(Buffer b){
		if(thread == null){
			thread = new Thread(this);
		}
		
		buffer = b;
	}
	
	// Metoda pentru pornirea threadului
	public  void start(){
		thread.start();
	}
	
	public void run(){
		char value;
		
		// Preluam valorile din buffer si le printam in consola
		for (int i = 0; i < 10; i++){
			value = buffer.get();
			System.out.println("Consumatorul a primit :\t" + value);
		}
	}
}
