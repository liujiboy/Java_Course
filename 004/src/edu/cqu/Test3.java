package edu.cqu;

public class Test3 {

	
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
		Integer k=null;
		System.out.println(k);
	}

}
