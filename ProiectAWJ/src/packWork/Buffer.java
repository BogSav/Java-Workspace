package packWork;

import java.awt.image.BufferedImage;

public class Buffer extends AbstractBuffer{
	// Avem un vector de BuffredImages deoarece consumer-ul are nevoie de cate doua imagini
	// Avem un vector de stari de available deoarece vrem sa stim cand sunt ambele imagini disponibile
	private BufferedImage[] images;
	private boolean[] availableStates;
	private int nrOfImages;
	
	// Acest constructor initializeaza vectorii si seteaza starile initiale cu false, deoarece nu este nimic disponibil
	public Buffer(int nrOfImages){
		this.images = new BufferedImage[nrOfImages];
		this.availableStates = new boolean[nrOfImages];
		this.nrOfImages = nrOfImages;
	
		setAvailable(false);
	}
	
	// Functie sincronizata ce returneaza catre consumator vectorul de imagini si face starile de disponibilitate false, 
	// deoarece se presupune ca nu mai sunt disponibile
	@Override
	public synchronized BufferedImage[] GetImages(){
		while(!getAvailable()){
			try{
				wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		setAvailable(false);
		notifyAll();
		
		return images;
	}
	
	// Functie sincronizata ce pune pe rand cate o imagine in vector, pana au fost puse toate si pot fi primite de catre consumator
	@Override
	public synchronized void put(BufferedImage image, int currentImage){
		while(availableStates[currentImage]){
			try{
				wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		images[currentImage] = image;
		availableStates[currentImage] = true;
		notifyAll();
	}
	
	// In aceasta metoda, toate starile de disponibilitate sunt setate cu aceeasi valoare data ca parametru
	private void setAvailable(boolean state){
		for(int i = 0; i < this.nrOfImages; i++){
			availableStates[i] = state;
		}
	}
	
	// In aceasta metoda, se verifica daca toate starile sunt disponibile (caz in care returneaza true, altfel false)
	private boolean getAvailable(){
		for(int i = 0; i < this.nrOfImages; i++){
			if(!availableStates[i])
				return false;
		}
		return true;
	}
}
