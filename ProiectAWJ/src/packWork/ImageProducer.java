package packWork;

public class ImageProducer extends ThreadedImage implements Runnable{
	// Intrucat vom avea mai multi producatori, deoarece avem de procesat mai multe imagini (doua),
	// vom memora intr-o variabila statica numarul lor, si astfel, setam fiecarei instante cate un ID
	private static int nrOfProducers = 0;
	private int producerID;
	
	// In acest constructor cream un thread nou, apelam constructorul parent class-ului si setam un ID pentru instanta curenta
	public ImageProducer(String path, int width, int height, Buffer buffer){
		super(path, width, height, buffer);
		
		producerID = nrOfProducers;
		nrOfProducers++;
		
		if(super.thread == null){
			super.thread = new Thread(this);
		}
		
		this.buffer = buffer;
	}
	
	// Functia ce va fi rulata de catre thread
	@Override
	public void run(){
		// Sectionam imaginea in 4 parti si le trimitem secvential catre buffer, 
		// de unde vor fi preluate ulterior de catre consumator
		for(int i = 0; i < 4; i++){
			buffer.put(
				image.getSubimage(
						(i % 2) * (getWidth() / 2), 
						(i / 2) * (getHeight() / 2),
						getWidth() / 2,
						getHeight() / 2),
				producerID
				);
			
			// Dupa ce este trimis fiecare sfert din imagine, se afiseaza un mesaj corespunzator
			// si se blocheaza thread-ul timp de o secunda
			System.out.println(
					"S-a trimis: " + 100 * (i + 1) / 4 + "% din imaginea producatorului " + producerID);
			
			sleep(1000);
		}
	}
}
