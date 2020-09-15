/**
 * 
 */
package code0405.mypack;

/**
 * NewPoint.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class NewPoint { 
	public double x, y;

	public NewPoint(double a, double b) {
		x = a;
		y = b;
	}

	public double distanceTo(NewPoint p) { // 该点到另一点p的距离
		return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
	}
}
