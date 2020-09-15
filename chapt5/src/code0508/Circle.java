/**
 * 
 */
package code0508;

/**
 * Circle.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
class Circle extends Shape { 
	private double r = 0; // 圆的半径 
	private final static double PI = 3.14; 
	public Circle(double r) { 
		this.r = r; 
	} 
/*重写getArea()方法*/
	public double getArea() { 
		return (PI * r * r); 
	} 
} 
