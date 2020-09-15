/**
 * 
 */
package code0404;

/**
 * PassTest.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class PassTest {
	float ptValue;

	public void changeInt(int value) {
		System.out.println("In changeInt:" + value);
		value = 55;
	}

	public void changeArrayValue(int xc[]) {
		System.out.println("In changeArrayValue:" + xc[1]);
		xc[1] = 6;
	}

	public static void main(String args[]) {
		int val = 11;
		int sc[] = { 1, 9 };
		PassTest pt = new PassTest();
		pt.ptValue = 20; // 引用成员变量ptValue
		pt.changeInt(val); // 方法调用（传值调用形式）
		System.out.println("Current Int value is: " + val);
		pt.changeArrayValue(sc); // 方法调用（引用形式）
		System.out.println(" Current Value in array is: " + sc[1]);
	}
}
