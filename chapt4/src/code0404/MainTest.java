/**
 * 
 */
package code0404;

/**
 * MainTest.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class MainTest {
	public static void main(String args[]) {
		int n = args.length; // 取得参数的个数
		if (n == 0)
			System.out.println(" no parament ! ");
		else {
			System.out.println(" number of paraments : " + n);
			for (int i = 0; i < n; i++)
				System.out.println(" args[ " + i + " ] = " + args[i]);
		}
	}
}
