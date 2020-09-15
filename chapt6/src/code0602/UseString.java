/**
 * 
 */
package code0602;

/**
 * UseString.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class UseString {
	public static void main(String args[]) {
		int n1, n2, n3;
		String vb = "Visual Baisc", ja = "java", s4 = "C++", s1, s2, s3;
		s1 = vb.concat(ja);
		s2 = s1.substring(8, 16);
		s3 = vb.replace('a', 'x');
		n1 = s1.length();
		n2 = s1.indexOf(ja);
		n3 = s1.lastIndexOf("Visual");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
	}

}
