// Sava Nicolae Bogdan 331AB

package packWork;

public class Buffer {
	private char character;
	private boolean available = false;
	
	// Functia sincronizata de returnare a acaracterului curent ce se afla in buffer
	public synchronized char get(){
		while(!available){
			try{
				wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		available = false;
		notifyAll();
		return character;
	}
	
	// Functia sincronizata de primire a unui caracter si de memorarare a acestuia in buffer
	public synchronized void put(char character){
		while(available){
			try{
				wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.character = character;
		available = true;
		notifyAll();
	}
}
