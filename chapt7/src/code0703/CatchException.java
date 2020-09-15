package code0703;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchException {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("test.txt");
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print(b);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
			}
		}
	}
}
