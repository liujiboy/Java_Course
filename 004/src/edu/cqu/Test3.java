package edu.cqu;
/**
 * Integer是类，所以它定义的变量是引用类型。
 * int是基础类型，所以它定义的变量是值。
 * 引用类型必须初始化，但将其作为成员变量时默认初始化为null。
 * @author 刘骥
 *
 */
public class Test3 {
	private static Integer z;
	public static void main(String[] args) {
		Integer a=new Integer(1);
		Integer b=new Integer(1);
		System.out.println(a==b);
		Integer c=new Integer(1);
		Integer d=1;
		System.out.println(c==d);
		Integer e=1;
		Integer f=1;
		System.out.println(e==f);
		Integer g=1;
		int h=1;
		System.out.println(g==h);
		int i=1;
		int j=1;
		System.out.println(i==j);
		System.out.println(a.equals(b));
		Integer k = null;
		System.out.println(k);
		System.out.println(z);
	}

}
