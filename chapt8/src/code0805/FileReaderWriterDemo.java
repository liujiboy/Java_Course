package code0805;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileReaderWriterDemo
{
	public static void main(String[] args) throws IOException
	{
		// 构造输入流对象
		File file = new File("src/code0805/FileReaderWriterDemo.java");
		FileReader f = new FileReader(file);
		FileWriter fout = new FileWriter("copy-of-file.txt");
		System.out.println("当前字符集是：" + f.getEncoding());
		int n = (int) (file.length() / 10);
		char b[] = new char[n];//构造字节数组，缓存文件内容
		int count = 0;
		System.out.println("开始复制");
		int times=0;
		while ((count = f.read(b, 0, n)) != -1)
		{
			times++;
			fout.write(b, 0, count);}
		System.out.println("结束复制,使用数组复制次数："+times);
		f.close();
		fout.close();
	}
}
