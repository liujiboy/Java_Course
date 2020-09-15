/**
 * 
 */
package code0301;

/**
 * AvgGrade.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */

public class AvgGrade {
	public static void main(String args[]) {
		int total = 0;
		int s[] = { 75, 69, 80, 85, 93, 97, 79, 77, 68, 90 }; // 定义数组变量s并赋值
		double avg = 0;
		for (int i = 0; i < 10; i++) {
			total = total + s[i]; // 访问数组成员s[i]
		}
		avg = total / 10.0; // 求平均分avg
		System.out.println("The average score is :" + avg);
	}
}
