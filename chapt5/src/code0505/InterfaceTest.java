/**
 * 
 */
package code0505;

/**
 * InterfaceTest.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
interface IA {
	int a = 1;

	void showa();
}
interface IB extends IA { // 接口IB继承自IA
	int b = 2;

	void showb();
}
interface IC extends IA, IB { // 接口C继承自IA,IB
	int c = 3;

	void showc();
}
public class InterfaceTest implements IC {
	public void showa() {
		System.out.println("aaaa");
	}

	public void showb() {
		System.out.println("bbbb");
	}

	public void showc() {
		System.out.println("cccc");
	}
}
