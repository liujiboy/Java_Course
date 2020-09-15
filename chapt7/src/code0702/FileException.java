package code0702;

import java.io.FileInputStream;
import java.io.IOException;

public class FileException {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("test.txt");
		int b;
		while((b=fis.read())!=-1){
			System.out.print(b);
		}
		fis.close();
	}
}
