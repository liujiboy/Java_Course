package code0202;

/**
* HelloWorldApp.java
* Copyright (c) 2016 ChongQing University All rights reserved.
*/
public class HelloWorldApp {
	int j = 5; // 此处j为类成员变量

	public static void main(String[] args) {
		double j = 10; // 此处j为方法main的局部变量
		System.out.println("Hello, world!");
		System.out.println(j); // 输出double类型的变量j.
	}// double j 作用域结束
}// int j 作用域结束
