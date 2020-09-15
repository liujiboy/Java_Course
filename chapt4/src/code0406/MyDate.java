/**
 * 
 */
package code0406;

/**
 * MyDate.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class MyDate {
	private int day, month, year; // 定义私有变量
	public void tomorrow() {
		day = day + 1; // 本类中可以引用使用私有变量
	}
	public void setDay(int d) {
		day = d;
	}
}
