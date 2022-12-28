package packWork;

import java.io.PipedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class ImageConsumer extends ThreadedImage implements Runnable{
	private int action;
	private DataOutputStream out;
	private Timer timer;
	
	// In acest constructor setam dimensiunile imaginii finale, instantiem imaginea finala, ce va fi trimisa ulterior
	// se seteaza tipul actiunii si instantiem un timer pentru a masura durata etapei de procesare si creem un thread nou
	public ImageConsumer(int width, int height, Buffer buffer, int action, PipedOutputStream pipeOut){
		super(width, height, buffer);
		
		this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		this.action = action;
		this.timer = new Timer();
		
		this.out = new DataOutputStream(pipeOut);
		
		if(super.thread == null){
			super.thread = new Thread(this);
		}
		
		this.buffer = buffer;
	}
	
	// Functia ce va procesa pixelii. Aici vom extrage din buffer cate doua bucati de imagine si le vom procesa
	// la nivel de pixel. Pixelii vor fi salvati in imaginea finala ce va fi trimisa ulterior catre writer
	public void run(){
		timer.Set();
		
		for(int i = 0; i < 4; i++){
			BufferedImage[] images = buffer.GetImages();
			for(int y2 = 0; y2 < getHeight() / 2; y2++){
				for(int x2 = 0; x2 < getWidth() / 2; x2++){
					this.image.setRGB(
						(i % 2) * (getWidth() / 2) + x2,
						(i / 2) * (getHeight() / 2) + y2,
						// Aici alegem ce actiune sa executam in functie de ce a ales utilizatorul
						action == 1 ? 
							images[0].getRGB(x2, y2) & images[1].getRGB(x2, y2)
								: (action == 2 ? images[0].getRGB(x2, y2) | images[1].getRGB(x2, y2)
										: images[0].getRGB(x2, y2) ^ images[1].getRGB(x2, y2))
							);		
				}
			}
			
			// Afisam un mesaj corespunzator la fiecare sfert de informatie procesat
			System.out.println("S-a procesat: " + 100 * (i + 1) / 4 + "% din informatia primita");
			
			// Blocam thread-ul 1 secunda asa cum este cerut
			sleep(1000);
		}
		
		// Afisam cat timp a durat intreaga operatie de procesare (in acest timp sunt incluse pauzele de cate o secunda)
		System.out.println("Operatia de procesare a durat: " + timer.GetSeconds() + " secunde");
		
		// Apelam functia ce va trimite imginea finala catre writer
		SendProcessedDataToWriter();
	}
	
	// Aceasa functie trimite printr-un pipe fiecare pixel catre writer
	private void SendProcessedDataToWriter(){
		for (int x = 0; x < getWidth(); x++){
			for(int y = 0; y < getHeight(); y++){
				try{
					out.writeInt(image.getRGB(x, y));
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}
