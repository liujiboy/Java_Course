/**
 * 
 */
package code0502;

/**
 * simple.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
class A {
	int i;

	void showi() {
		System.out.println("i: " + i);
	}
}

class B extends A {
	int k;

	void show() {
		System.out.println("k: " + k);
		showi();
	}

	void sum() {
		System.out.println("i+k: " + (i + k));
	}
}

public class Simple {
	public static void main(String args[]) {
		A superOb = new A();
		B subOb = new B();
		superOb.i = 10; // 对父类对象的成员赋值.
		System.out.println("Contents in 父类: ");
		superOb.showi();
		subOb.i = 7; // 对子类中继承得到的变量i赋值
		subOb.k = 9;
		System.out.println("Contents in 子类: ");
		subOb.show();
		System.out.println("Sum of i and k in 子类:");
		subOb.sum();
	}
}
