/**
 * 
 */
package code0405;

/**
 * UsePoint.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import code0405.mypack.NewPoint; 

public class UsePoint {
	public static void main(String[] args) {
		NewPoint p1 = new NewPoint(1.0, 2.0); // 创建2个NewPoint对象
		NewPoint p2 = new NewPoint(2.0, 5.5);
		System.out.println("点p1坐标: " + p1.x + ", " + p1.y);
		System.out.println("点p2坐标: " + p2.x + ", " + p2.y);
		System.out.println("点p1到点p2的距离：" + p1.distanceTo(p2));
	}
}
