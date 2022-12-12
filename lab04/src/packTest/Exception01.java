package packTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exception01 {
	public void initMethod(){
		File myFile = new File("D:\\file1.txt");
		try{
			FileReader myFileReader = new FileReader(myFile);	
		}
		catch (FileNotFoundException e){
			System.out.println("sdf");
			e.printStackTrace();
		}
	}
}
