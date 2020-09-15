/**
 * 
 */
package code0206;

/**
 * SampleWhile.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class SampleWhile {
	public static void main(String[] args) {
		int sum = 0, i = 100;
		while (i < 200) {
			i++;
			sum += i;
		}
		System.out.println("the sum is " + sum);
	}

}
