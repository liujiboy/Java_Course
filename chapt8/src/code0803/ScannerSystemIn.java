package code0803;
import java.util.Scanner;
public class ScannerSystemIn {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);//封装标准输入流
		int a = sin.nextInt();//读取整数
		double b = sin.nextDouble();//读取浮点数
		double result = a * b;
		System.out.println("a*b=" + result);
	}
}
