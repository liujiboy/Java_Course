package code0804;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamCopy {
	public static void main(String[] args) throws IOException {
		int size;
		// 构造输入/出流对象
		FileInputStream f = new FileInputStream("src/code0804/BufferedStreamCopy.java");
		FileOutputStream fout = new FileOutputStream("copy-of-file.txt");
		// 使用缓冲流
		BufferedInputStream bis = new BufferedInputStream(f);
		BufferedOutputStream bos = new BufferedOutputStream(fout);
		System.out.println("开始复制...");
		int n = f.available() / 5;
		byte b[] = new byte[n];
		int count = 0;
		while ((count = bis.read(b, 0, n)) != -1)
			bos.write(b, 0, count);
		System.out.println("完成复制");
		bis.close();
		bos.flush();
		bos.close();
		f.close();
		fout.flush();
		fout.close();
	}
}
