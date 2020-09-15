/**
 * 
 */
package code0503;

/**
 * Poly.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
class A {
	void callme() {
		System.out.println("inside A");
	}
}
class B extends A {
	void callme() {
		System.out.println("inside B");
	}
}
class Poly {
	public static void main(String args[]) {
		A a = new A();
		B b = new B();
		A c = new B();
		a.callme();
		b.callme();
		c.callme();
	}
}
