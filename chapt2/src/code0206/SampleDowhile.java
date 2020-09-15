/**
 * 
 */
package code0206;

/**
 * SampleDowhile.
 * java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
public class SampleDowhile {
	public static void main(String[] args) {
		int sum = 0, i = 100;
		do {
			i++;
			sum += i;
		} while (i < 200);
		System.out.println("the sum is " + sum);
	}

}
