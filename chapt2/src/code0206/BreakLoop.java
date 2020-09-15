/**
 * 
 */
package code0206;

/**
 * BreakLoop.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class BreakLoop {
	public static void main(String args[]) {
		for (int i = 0; i < 100; i++) {
			if (i == 5)
				break; // 如果i等于5，终止循环
			System.out.println("i: " + i);
		}
		System.out.println("Loop complete.");
	}

}
