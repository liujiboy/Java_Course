/**
 * 
 */
package code0508;

/**
 * TestShape.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class TestShape{ 
	public static void main(String[] args) { 
		Shape square = new Square(3) ; // 构造一个边长为3的正方形
		Shape circle = new Circle(2) ; // 构造一个半径为2的圆
		Shape triangle1 = new Triangle(3, 4, 5); // 构造一个边长分别为3,4,5的三角形
		Shape triangle2 = new Triangle(3, 4); // 构造一个高和底分别为3,4的三角形 
		System.out.println(square.getArea()); 
		System.out.println(circle.getArea()); 
		System.out.println(triangle1.getArea()); 
		System.out.println(triangle2.getArea()); 
	} 
}
