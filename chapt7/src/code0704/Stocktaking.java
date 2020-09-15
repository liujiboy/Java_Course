package code0704;

import java.io.*;
import java.text.NumberFormat;

public class Stocktaking {

	public static void main(String[] args) throws IOException {
		String numBoxesIn;

		int numBoxes;

		double boxPrice = 3.25;

		NumberFormat currency = NumberFormat.getCurrencyInstance();

		System.out.println("有多少个盒子：");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 构建输入流以接收用户的输入数据

		numBoxesIn = in.readLine();

		try {

			numBoxes = Integer.parseInt(numBoxesIn);

			if (numBoxes < 0) {

				throw new NegativeNumberException();

			}

			System.out.println("盒子的总价值是：");

			System.out.println(currency.format(numBoxes * boxPrice));

		} catch (NumberFormatException e) {

			System.out.println("输入的不是一个整数。");

		} catch (NegativeNumberException e) {

			System.out.println("盒子数量不可能为负数。");

		}

	}

}

class NegativeNumberException extends Exception {

}
