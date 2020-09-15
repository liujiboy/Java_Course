package code0801;
import java.io.FileWriter;
public class SimpleFileStream {
	public static void main(String[] args) throws Exception {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		// 输出控制台
		System.out.println("计算结果1：" + sum);
		// 构建文件输出流，输出到文件f1.txt中
		FileWriter fout = new FileWriter("f1.txt");
		fout.write("计算结果2：" + sum);
		fout.close();
	}
}
