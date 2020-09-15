/**
 * 
 */
package code0504;

/**
 * Real.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
abstract class Abs {
	abstract void show();

	abstract void show(int i);
}

/* 定义抽象类Abs的子类Real */
public class Real extends Abs {
	int x;

	void show() { // 实现抽象方法abstract void show( )
		System.out.println("x=" + x);
	}

	void show(int i) { // 实现抽象方法abstract void show(int i)
		x = i;
		System.out.println("x=" + x);
	}
}
