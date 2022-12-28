package packTest;

import packWork.Buffer;
import packWork.ImageConsumer;
import packWork.ImageProducer;
import packWork.ImageWriter;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
	// Variabilele default, ce vor fi folosite doar daca utilizatorul doreste
	private static final String defaultImage1Path;
	private static final String defaultImage2Path;
	private static final String defaultFinalImagePath;
	private static final int defaultWidth;
	private static final int defaultHeight;
	
	// Variabilele ce urmeaza a fi folosite pentru operatiile de procesare a imaginilor
	private static int width;
	private static int height;
	private static String image1Path;
	private static String image2Path;
	private static String finalImagePath;
	private static int action;
	
	// In urmatorul bloc static am initializat path-urile default, cat si dimensiunile default ale imaginilor
	static{
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString() + "\\src\\Imagini";
		
		defaultImage1Path = s + "\\FirstImg.bmp";
		defaultImage2Path = s + "\\SecondImg.bmp";
		defaultFinalImagePath = s + "\\FinalTest.bmp";
		
		defaultWidth = 1920;
		defaultHeight = 1080;
	}
	
	public static void main(String[] args) throws IOException {
		// Mai intaim setam path-urile si dimensiunile imaginilor ce vor fi utilizate
		SetupVariables();
		
		// Instantiem buffer-ul, cu dimensiunea 2 - deoarece procesam 2 imagini simultan
		Buffer b = new Buffer(2);
		
		// Instantiem cei 2 produceri ce vor scrie asincron bucati de imagine in buffer
		ImageProducer p1 = new ImageProducer(image1Path, width, height, b);
		ImageProducer p2 = new ImageProducer(image2Path, width, height, b);
		
		// Instantiem pipe-urile ce vor fi folosite pentru a trsnamite date intre consumator si writer
		PipedOutputStream pipeOut = new PipedOutputStream();
		PipedInputStream pipeIn = new PipedInputStream(pipeOut);
		
		// Instantiem consumatorul si writer-ul
		ImageConsumer c1 = new ImageConsumer(width, height, b, action, pipeOut);
		ImageWriter resultWriter = new ImageWriter(finalImagePath, width, height, pipeIn);
		
		// Pornim cele 4 thread-uri (2 produceri, consumatorul si writer-ul)
		p1.start();
		p2.start();
		
		c1.start();
		
		resultWriter.start();
	}
	
	private static void SetupVariables() throws IOException{
		// Creem un nou scanner pentru a citi valori date in consola de la tastatura
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		// Oferim posibilitatea de a utiliza modul de exemplificare cu path-uri si dimensiuni default
		System.out.println("Folositi path-urile default?(y/n)");
	    String defaultType = scanner.nextLine();
	    
	    if(defaultType.equals("y")){
		    // Setam valorile la cele default
	    	image1Path = defaultImage1Path;
	    	image2Path = defaultImage2Path;
	    	finalImagePath = defaultFinalImagePath;
	    	
	    	width = defaultWidth;
	    	height = defaultHeight;
	    }else{
	    	// Citim de la tastatura path-urile si dimensiunile imaginilor
			System.out.println("Introduceti path-ul primei poze (path-ul absolut)");
			image1Path = scanner.nextLine();
			System.out.println("Introduceti path-ul celei de-a doua poze (path-ul absolut)");
			image2Path =scanner.nextLine();
			System.out.println("Introduceti path-ul imaginii finale (unde urmeaza sa fie salavata si numele)");
			finalImagePath = scanner.nextLine();
			
			System.out.println("Introduceti latimea imaginilor");
			width = scanner.nextInt();
			System.out.println("Introduceti inaltimea imaginilor");
			height = scanner.nextInt();
	    }
	    
	    // Alegem tipul de actiune AND/OR/XOR
	    System.out.println("Alegeti tipul actiunii (1-AND, 2-OR, 3-XOR)");
	    action = scanner.nextInt();
	}
}














