package edu.cqu;

public class Test2 {

	static void fun(int a[])
	{
		a[0]++;
	}
	public static void main(String[] args) {
		int a[]={0};
		fun(a);
		int b[]=a;
		b[0]++;
		System.out.println(a);
		System.out.println(a[0]);

	}

}
