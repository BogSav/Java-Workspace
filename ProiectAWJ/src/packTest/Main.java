package packTest;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Main {
	
	public static void main(String[] args) {
		int width = 1920;    //width of the image
		int height = 1080;   //height of the image
		
		BufferedImage image = null;
		File f = null;
		
		try{
			f = new File("G:\\Java-Workspace\\ProiectAWJ\\Imagini\\FirstImg.bmp"); //image file path
			BufferedImage fullImage1 = ImageIO.read(f);
			BufferedImage fullImage2 = ImageIO.read(new File("G:\\Java-Workspace\\ProiectAWJ\\Imagini\\SecondImg.bmp"));
			
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			 for (int xPixel = 0; xPixel < width; xPixel++)
		        {
		            for (int yPixel = 0; yPixel < height; yPixel++)
		            {
		                int color = fullImage1.getRGB(xPixel, yPixel);
		                int color2 = fullImage2.getRGB(xPixel, yPixel);
		                // System.out.println(color);
		                image.setRGB(xPixel, yPixel, color ^ color2);
		            }
		        }
		    System.out.println("Reading complete.");
		}catch(IOException e){
			System.out.println("Error: " + e);
		}
		
		try{
		    f = new File("G:\\Java-Workspace\\ProiectAWJ\\Imagini\\FinalImage.bmp");  //output file path
		    ImageIO.write(image, "bmp", f);
		    System.out.println("Writing complete.");
		}catch(IOException e){
		      System.out.println("Error: "+e);
		}
	}

}
