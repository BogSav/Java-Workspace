package packWork;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PipedInputStream;

import javax.imageio.ImageIO;

public class ImageWriter extends Image implements Runnable, ThreadFunctionality {
	private DataInputStream in;
	private Timer timer;
	
	private Thread thread = null;
	private String path;
	
	// In acest constructor setam path-ul imaginii finale, dimensiunile sale cat si pipe-ul folosit pentru
	// primirea fiecarui pixel trimis de catre consumator. Tot aici este creat si un nou thread pentru acest lucru
	public ImageWriter(String path, int width, int height, PipedInputStream pipeIn){
		super(width, height);
		
		this.in = new DataInputStream(pipeIn);
		this.path = path;
		this.timer = new Timer();
		
		if(thread == null){
			thread = new Thread(this);
		}
	}
	
	// Aceasta este functia prin care este primit fiecare pixel al imaginii si este reconstruita imginea finala
	@Override
	public void run(){
		image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		
		timer.Set();
		
		int prevProgress = -1;
		for (int x = 0; x < getWidth(); x++){
			for(int y = 0; y < getHeight(); y++){
				// Citim cate un pixel si il setam in pozitia corespunztoare din imginea finala
				try{
					int pixel = in.readInt();
					image.setRGB(x, y, pixel);
				}
				catch(IOException e){
					e.printStackTrace();
				}
				
				// Verificam daca progresul este la cate un sfaert, caz in care afisam mesaje corespunztoare
				int progress = 100 * (x * getHeight() + y) / getWidth() / getWidth();
				if(progress != prevProgress && progress % 25 == 0){
					System.out.println("A fost primita " + (progress + 25) + "% din informatie pentru a fi scrisa");
					prevProgress = progress;
					
					sleep(1000);
				}
			}
		}
		
		// Afisam durata procesului de primire a datelor pentru a fi scrise
		System.out.println("A fost primita 100% din informatie pentru a fi scrisa");
		System.out.println("Operatia de primire a datelor pentru a fi scrise s-a executat in: " + timer.GetSeconds() + " secunde");
		
		timer.Set();
		// Scrieerea propriu-zisa a imaginii finale la path-ul dat de utilizator
		try{
		    File file = new File(path);
		    ImageIO.write(image, "bmp", file);
		    System.out.println("Operatia de scriere s-a executat cu succes");
		}catch(IOException e){
			e.fillInStackTrace();
		}
		// Afisam durata procesului de scriere
		System.out.println("Operatia de scriere a imaginii a durat: " + timer.GetSeconds() + " secunde");
	}
	
	@Override
	public void start(){
		thread.start();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void sleep(int duration){
		try{
			thread.sleep(duration);
		}
		catch (InterruptedException e){
			
		}
	}
}
