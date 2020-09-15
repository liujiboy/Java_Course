/**
 * 
 */
package code0508;

/**
 * Square.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
class Square extends Shape { 
	private double height = 0;  // 正方形的边长
	public Square(double height) { 
		this.height = height; 
	}

/*重写getArea()方法*/
	public double getArea() { 
		return (this.height * this.height); // Math.pow(this.height , 2); 
	} 
} 

