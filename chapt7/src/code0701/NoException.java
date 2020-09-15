package code0701;

import java.io.*;
import java.text.NumberFormat;

public class NoException {
	public static void main(String[] args) throws IOException {
		String numBoxesIn;
		int numBoxes;
		double boxPrice = 3.25;
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println("有多少个盒子：");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 构建输入流以接收用户的输入数据
		numBoxesIn = in.readLine();
		numBoxes = Integer.parseInt(numBoxesIn);
		System.out.println("盒子的总价值是：");
		System.out.println(currency.format(numBoxes * boxPrice));
	}
}
