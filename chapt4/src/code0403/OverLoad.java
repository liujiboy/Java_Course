/**
 * 
 */
package code0403;

/**
 * OverLoad.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class OverLoad {
	int sum(int a, int b) { // 定义双操作数的sum方法
		return a + b;
	}

	int sum(int a, int b, int c) { // 重载的三操作数sum方法
		return a + b + c;
	}

	public static void main(String[] args) {
		OverLoad o = new OverLoad();
		System.out.println(o.sum(1, 5)); // 调用双操作数sum方法
		System.out.println(o.sum(3, 5, 8)); // 调用三操作数sum方法
	}
}
