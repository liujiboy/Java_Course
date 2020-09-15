/**
 * 
 */
package code0507;

/**
 * GeneMethodDemo.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
class NewPoint<T1, T2> {
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

	// 定义泛型方法printPoint
	public <T1, T2> void printPoint(T1 x, T2 y) {
		T1 m = x;
		T2 n = y;
		System.out.println("This point is：" + m + ", " + n);
	}
}

public class GeneMethodDemo {
	public static void main(String[] args) {
		NewPoint<Integer, Integer> p1 = new NewPoint<Integer, Integer>();
		p1.setX(10);
		p1.setY(20);
		p1.printPoint(p1.getX(), p1.getY()); // 调用泛型方法printPoint
		NewPoint<Double, String> p2 = new NewPoint<Double, String>();
		p2.setX(25.4);
		p2.setY("东经180度");
		p2.printPoint(p2.getX(), p2.getY()); // 调用泛型方法printPoint
	}
}



