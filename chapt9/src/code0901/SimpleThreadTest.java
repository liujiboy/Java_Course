/**
 * 
 */
package code0901;

/**
 * SimpleThreadTest.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
public class SimpleThreadTest {
	public static void main(String[] args) {
		// 创建线程对象:
		Thread sum = new SumThread();
		Thread squareSum = new SquareSumThread();
		// 启动线程
		sum.start();
		squareSum.start();
	}
}

// 继承Thread创建线程
class SumThread extends Thread {
	public void run() {
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum += i * i;
		}
		System.out.println("平方和:" + sum);
	}
}

// 继承Thread创建线程
class SquareSumThread extends Thread {
	public void run() {
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum += i;
		}
		System.out.println("和:" + sum);
	}

}
