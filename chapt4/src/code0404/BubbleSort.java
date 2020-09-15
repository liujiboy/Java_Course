/**
 * 
 */
package code0404;

import java.util.Scanner;

/**
 * BubbleSort.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class BubbleSort {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in); // Scanner类用于获取用户从控制台的输入，详见第8章
		int[] numbers = new int[8];
		System.out.print("Please enter eight number:");
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = scanner.nextInt();       //通过nextInt方法依次读取用户输入数字并存入数组中
		for (int i = numbers.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
		System.out.println("冒泡排序的结果是：");
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
}
