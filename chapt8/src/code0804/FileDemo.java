package code0804;
import java.io.File;
import java.io.IOException;

public class FileDemo {
	public static void main(String[] args) throws IOException {
		File dir = new File("src/code0804");
		File f1 = new File(dir, "FileDemo.java");
		System.out.println(f1);
		System.out.println("exist: " + f1.exists());
		System.out.println("name:  " + f1.getName());
		System.out.println("path:  " + f1.getPath());
		System.out.println("abosolute path:" + f1.getAbsolutePath());
		System.out.println("parent:  " + f1.getParent());
		System.out.println("is a file :  " + f1.isFile());
		System.out.println("is a directory:     " + f1.isDirectory());
		System.out.println("length:   " + f1.length());
        File temp=File.createTempFile("ÁÙÊ±ÎÄ¼þ", ".tmp");
    	System.out.println("abosolute path:     " + temp.getAbsolutePath());
        System.out.println("length:  "+temp.length());
	}
}
