package packTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DemoExceptionsClass {
	public void testExceptionUnchecked() {
		int num[] = {1, 2, 3, 4, 5};

		System.out.println("testExceptionUnchecked started");
		
		System.out.println(num[3]);
		
		System.out.println("testExceptionUnchecked ended");
	}

	public void testExceptionChecked() {
		System.out.println("testExceptionChecked started");
		File myFile = new File("D:\\file1.txt");
		try {
			System.out.println("testExceptionChecked try started");
			FileReader myFileReader = new FileReader(myFile);
			System.out.println("testExceptionChecked try ended");
		} catch (FileNotFoundException e) {
			System.out.println("testExceptionChecked catch started");
			e.printStackTrace();
		}
		System.out.println("testExceptionChecked ended");
		
	}
}
