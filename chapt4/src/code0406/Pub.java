/**
 * 
 */
package code0406;

/**
 * Pub.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
class Pub {
	public int x; // 公有数据

	public void set_x(int i) { // 公有方法
		x = i;
	}

	public void show_x() {
		System.out.println("x=" + x);
	}
}
