/**
 * 
 */
package code0406;

/**
 * PubTest.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
class PubTest {
	public static void main(String args[]) {
		Pub obj = new Pub();
		obj.set_x(3);
		obj.show_x();
		obj.x = 10; // 在类Example中访问类P1中的公有数据
		System.out.println("x=" + obj.x);
	}
}
