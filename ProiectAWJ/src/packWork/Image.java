package packWork;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Image {
	protected BufferedImage image = null;
	private int width;
	private int height;
	
	// Constructor ce ia ca argumente doar latimea si inaltimea unei imagini, si lasa obiectul
	// de tip BuffredImage neinitializat, pentru a putea fi instantiat ulterior
	public Image(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	// Constructor ce primeste atat dimensiunile imaginii cat si path-ul imaginii ce urmeaza a fi citite
	public Image(String path, int width, int height){
		// Intr-un bloc try/catch cititim imaginea
		try{
			File file = new File(path);
			this.image = ImageIO.read(file);
		}catch (IOException e){
			e.printStackTrace();
		}
		
		// Verificam daca dimensiunile imaginii citite corespund cu cele date de utilizator
		if (image.getWidth() != width || image.getHeight() != height){
			// Daca dimensiunile nu corespund, initializam totul null respectiv cu 0 si afisam un mesaj corespunzator
			System.out.println("Dimensiunile nu corespund");
			this.image = null;
			this.setHeight(0);
			this.setWidth(0);
		}
		else{
			// Daca dimensiunile corespund, le pastram si afisam un mesaj corespunzator
			this.setHeight(this.image.getHeight());
			this.setWidth(this.image.getWidth());
			
			System.out.println("Imaginea a fost citita cu succes!");
		}
	}

	// Getter si setter pentru latime
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	// Getter si setter pentru inaltime
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
