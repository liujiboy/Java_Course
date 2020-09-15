/**
 * 
 */
package code0506;

/**
 * Outer4.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
interface Exam {
	void print1();
}

public class Outer4 {
	public Exam test() {
		return new Exam() {
			public void print1() {
				System.out.println("Hello world!!");
			}
		};
	}

	public static void main(String args[]) {
		Outer4 c = new Outer4();
		Exam e = c.test();
		e.print1();
	}
}
