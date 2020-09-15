/**
 * 
 */
package code0403;

/**
 * Point.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
class Point {
	int x = 0;
	int y = 0;

	public void move(int dx, int dy) // 移动点坐标的方法
	{
		x = x + dx;
		y = y + dy;
	}
	public void alert() { // 无返回值的输出方法
		System.out.println("x=" + x + " y=" + y);
	}
	public static void main(String args[]) {
		Point p = new Point();
		p.move(1, 2);
		p.alert();
	}
}
