/**
 * 
 */
package code0304;

/**
 * ArraysDemo.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */

import java.util.Arrays;    
public class ArraysDemo {
	public static void main(String[] args) {
		Integer array[] = new Integer[9];
		for (int i = 1; i < 10; i++)
			array[i - 1] = (int) (Math.random() * 100);
		// 显示，排序数组
		System.out.print("原内容: ");
		display(array);
		Arrays.sort(array);
		System.out.print("排序后: ");
		display(array);
		// 将值-1分配给数组array中下标从0到3-1位置上的元素
		Arrays.fill(array, 0, 3, -1);
		System.out.print("执行 fill()后: ");
		display(array);
		// 搜索39
		System.out.print("值 39 的位置 ");
		int index = Arrays.binarySearch(array, 39);
		System.out.println(index);
		
	}
	static void display(Integer array[]) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
	}
}
