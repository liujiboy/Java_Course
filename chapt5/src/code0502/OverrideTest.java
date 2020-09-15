/**
 * 
 */
package code0502;

/**
 * OverrideTest.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
class SuperCla {
	int a = 3, b = 4;

	void show() {
		System.out.println("super result=" + (a + b));
	}
}

class SubCla extends SuperCla {
	int a = 10;

	void show() {
		int c = a * b;
		System.out.println("sub result=" + c);
	}
}

public class OverrideTest {
	public static void main(String args[]) {
		SuperCla sp = new SuperCla();
		SubCla sb = new SubCla();
		sp.show();
		System.out.println("In super Class:a=" + sp.a);
		sb.show();
		System.out.println("In sub Class:a=" + sb.a);
	}
}
