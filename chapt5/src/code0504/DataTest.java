/**
 * 
 */
package code0504;

/**
 * DataTest.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class DataTest {
	public static void main(String args[]){
		MyStack s = new MyStack();
		s.put('x');
		s.put('y');
		s.put('z'); // 向栈s中存入三个字符
		System.out.println("In Stack:");
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get()); // 从栈s中取数并显示

	}

}
