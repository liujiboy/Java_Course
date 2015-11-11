package edu.cqu;
/**
 * 由于Java中不存在指针类型，因此基础数据类型变量（如int、float、double、char等）的实参
 * 不能在函数中通过形参被修改。同时这些类型也不存在引用类型。若想修改，必须将这些变量作为
 * 类的成员变量，进而可以在成员函数中被修改。这也符合面向对象程序设计的规范。
 * @author 刘骥
 *
 */
public class Test1 {

	private static void fun(int a)
	{
		a++;
	}
	public static void main(String[] args) {
		int a=0;
		fun(a);
		System.out.println(a);

	}

}
