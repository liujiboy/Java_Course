/**
 * 
 */
package code0406;

/**
 * ProtTest.java Copyright (c) 2016 ChongQing University All rights reserved.
 */

class ProtTest extends Prot {              // 生成子类
	public static void main(String args[]) {
		ProtTest abs = new ProtTest();
		abs.show_n(); 					// 访问父类的被保护成员
		abs.n = 10; 					// 访问父类的被保护成员
		abs.show_n();
	}
}
