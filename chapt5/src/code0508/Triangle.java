/**
 * 
 */
package code0508;

/**
 * Triangle.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
class Triangle extends Shape { 
	private double a = 0; // 三角形的边1
	private double b = 0; // 三角形的边2 
	private double c = 0; // 三角形的边3
	private double h = 0; // 三角形的高 
	public Triangle(double a, double h) { 
		this.a = a; 
		this.h = h; 
	} 
	public Triangle(double a, double b, double c) { 
		this.a = a; 
		this.b = b; 
		this.c = c; 
	} 
/*重写getArea()方法*/
	public double getArea() { 
		if (h == 0) { 
			double s = (a+b+c)/2; 
			return Math.pow(s*(s-a)*(s-b)*(s-c), 0.5); // 根据海伦公式求三角形的面积 
		} else { 
			return ( a * h / 2); 
		} 
	} 
} 
