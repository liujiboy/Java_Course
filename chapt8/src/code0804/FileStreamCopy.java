package code0804;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamCopy {
	public static void main(String[] args) throws IOException {
		int size;
		// 构造输入流对象
		FileInputStream f = new FileInputStream("src/code0804/FileStreamCopy.java");
		FileOutputStream fout = new FileOutputStream("copy-of-file.txt");
		System.out.println("总长度: " + (size = f.available()));
		int n = size / 10;
		System.out.print("使用单字节方法读取后：");
		// 使用read()和write
		for (int i = 0; i < n; i++) {
			fout.write(f.read());
		}
		System.out.println("剩余长度: " + f.available());
		System.out.print("读取一个字节数组后：");
		// 使用read(byte[]b )和write(byte[] b);
		byte b[] = new byte[n];
		f.read(b);
		fout.write(b);
		System.out.println("剩余长度：" + f.available());
		// 使用read(b,offset,len)和write（b,offset,len）
		System.out.print("读取余下数据：");
		int count = 0;
		while ((count = f.read(b, 0, n)) != -1)
			fout.write(b, 0, count);
		System.out.println("剩余长度: " + f.available());
		// 最后注意关闭流
		f.close();
		fout.flush();
		fout.close();
	}
}
