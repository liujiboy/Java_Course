package code0805;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class StreamToReaderWriter
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("src/code0805/StreamToReaderWriter.java");
		FileInputStream fin = new FileInputStream(file);
		FileOutputStream fout = new FileOutputStream("copy-of-file.txt");
		// 把文件输入字节流向字符流转换
		InputStreamReader isr = new InputStreamReader(fin, "GBK");
		//把文件输出字节流向字符流转换
		OutputStreamWriter osw = new OutputStreamWriter(fout, "GBK");
		System.out.println("当前输入流编码是 :"
				+ isr.getEncoding());
		System.out.println("当前输出流编码是:"
				+ osw.getEncoding());
		int n = (int) (file.length() / 30);
		char b[] = new char[n];
		System.out.println("复制开始...");
		int count = 0;
		while ((count = isr.read(b, 0, n)) != -1)
			osw.write(b, 0, count);
		isr.close();
		fin.close();
		osw.flush();
		osw.close();
		fout.flush();
		fout.close();
		System.out.println("复制完成。");
	}
}
