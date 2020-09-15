/**
 * 
 */
package code0404;

/**
 * StaticTest.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
class StaticTest {
	static int statInt = 4;
	static double statDouble = 16.0;
	int instInt;
	double instDouble;

	public static void staticMethod() { // 输出静态变量的值
		System.out.println("statInt=" + statInt + "; statdouble=" + statDouble);
	}

	public void instMethod() { // 输出实例变量的值
		System.out.println("instInt=" + instInt + "; instdouble=" + instDouble);
	}

	public StaticTest(int intArg, double doubleArg) {
		instInt = intArg;
		instDouble = doubleArg;
	}

	public static void changestatic(int newInt, double newDouble) {// 改变静态变量的值
		statInt = newInt;
		statDouble = newDouble;
	}

	public static void main(String args[]) {
		StaticTest instance1 = new StaticTest(1, 2.0);
		StaticTest instance2 = new StaticTest(3, 4.0);
		instance1.instMethod();
		instance2.instMethod();
		StaticTest.staticMethod();
		StaticTest.staticMethod();
		instance2.staticMethod();
		instance1.changestatic(8, 8.0); // 改变静态变量的值
		instance2.staticMethod();
		StaticTest.staticMethod();
	}
}
