package edu.cqu;
/**
 * 数组、类对象都是引用类型，因此这些变量的实参可以通过函数的形参修改。
 * 与C++不同，数组、类对象不存在非引用类型，也不能定义指针。换言之，
 * 要么是引用，要么还是引用。
 * @author 刘骥
 *
 */
public class Test2 {

	private static void fun(int a[])
	{
		a[0]++;
	}
	public static void main(String[] args) {
		int a[]={0};
		fun(a);
		int b[]=a;
		b[0]++;
		System.out.println(a);
		System.out.println(b);
		System.out.println(a[0]);

	}

}
