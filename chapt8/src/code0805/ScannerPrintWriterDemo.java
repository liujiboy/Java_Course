package code0805;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
public class  ScannerPrintWriterDemo {
	public static void main(String[] args) {
		Scanner s = null;
		PrintWriter pw = null;
		try {
	//使用Scanner解析文件字符输入流的内容
			s = new Scanner(new FileReader("source.txt"));
			// 使用PrintWriter进行格式化输出
			pw = new PrintWriter("dest.txt");
			while (s.hasNextLine()) { //判断是否还有未读行
				String strLine = s.nextLine(); //读取一行
				// 调用方法求每一行的和
				int sum = getLineSum(strLine);
				// 输出每一行
				pw.println(strLine + "\t" + sum);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {// 关闭输入流和输出流
			if (s != null)
				s.close();
			if (pw != null)
				pw.close();
		}
	}
	// 计算每一行的和的方法
	private static int getLineSum(String strLine) {
		// 使用Scanner分割每一行为多个整数
		Scanner s = new Scanner(strLine); // 用Scanner解析字符串
		int sum = 0;
		while (s.hasNextInt()) {  //判断是否还有数据
			sum += s.nextInt();  // 获得下一个整数
		}
		return sum;
	}
}
