// Sava Nicolae Bogdan 331AB

package packWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CarProducer extends Car implements Runnable{
	private Thread thread = null;
	private Buffer buffer;
	
	// Constructorul folosit pentru instantierea bufferului si pentru crearea unui nou thread
	public CarProducer(Buffer b){
		if(thread == null){
			thread = new Thread(this);
		}
		
		buffer = b;
	}
	
	// Metoda pentru pornirea threadului
	public  void start(){
		thread.start();
	}
	
	// Citirea caracterelor si trimiterea lor in buffer
	public void run(){
		try{
			// Deschiderea fisierului si instantierea obiectelor ajutatoare pentru citirea caracterelor
			File file = new File("G:\\Java-Workspace\\lab05\\src\\packTest\\input.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			int c = 0; 
			
			// Vom citi caracterele pe rand pana ajungem la sfarsitul fisierului si le trimitem in buffer pe rand
			while((c = bufferedReader.read()) != -1)
			{
				buffer.put((char)c);
				System.out.println("Producator a pus :\t" + (char)c);
				try{
					thread.sleep((int)(Math.random() * 100));
				} catch (InterruptedException e) {}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}