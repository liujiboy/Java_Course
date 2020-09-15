/**
 * 
 */
package code0507;

/**
 * GeneDemo.java Copyright (c) 2016 ChongQing University All rights reserved.
 */

class Point<T1, T2> {
	T1 x;
	T2 y;

	public T1 getX() {
		return x;
	}

	public void setX(T1 x) {
		this.x = x;
	}

	public T2 getY() {
		return y;
	}

	public void setY(T2 y) {
		this.y = y;
	}
}

public class GeneDemo {
	public static void main(String[] args) {
		// 实例化泛型类
		Point<Integer, Integer> p1 = new Point<Integer, Integer>();
		p1.setX(10);
		p1.setY(20);
		int x = p1.getX();
		int y = p1.getY();
		System.out.println("This point is：" + x + ", " + y);

		Point<Double, String> p2 = new Point<Double, String>();
		p2.setX(25.4);
		p2.setY("东经180度");
		double m = p2.getX();
		String n = p2.getY();
		System.out.println("This point is：" + m + ", " + n);
	}
}
