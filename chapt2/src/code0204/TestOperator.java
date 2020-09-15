/**
 * 
 */
package code0204;

/**
 * TestOperator.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
public class TestOperator {
	public static void main(String[] args) {
		int i = 29;
		int j = 3;
		float a = 23.5f;
		double b = 4.0;
		System.out.println("i+a=" + (i + a)); // 整数与浮点数相加
		System.out.println("i*j=" + (i * j)); // 两个整数相乘
		System.out.println("i/j=" + (i / j)); // 对于整数，运算结果为整数
		System.out.println("i%j=" + (i % j)); // 求余数
		System.out.println("a*b=" + (a * b)); // 两个浮点数相乘
		System.out.println("a/b=" + (a / b)); // 对于浮点数，运算结果为浮点数
		System.out.println("a%b=" + (a % b)); // 浮点数求余，结果为浮点数
		System.out.println("i++=" + (i++)); // 先使用，后自增
		System.out.println("++i=" + (++i)); // 先自增，后使用
	}

}
