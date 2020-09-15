/**
 * 
 */
package code0404;

/**
 * StudentOverload.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
public class StudentOverload {
	int no;
	String name;

	StudentOverload(String l_name) {
		no = 0;
		name = l_name;
	}

	StudentOverload(int l_no, String l_name) {
		no = l_no;
		name = l_name;
	}

	public static void main(String args[]) {
		StudentOverload s1 = new StudentOverload("zhangShan");
		StudentOverload s2 = new StudentOverload(2, "xiaoMing");
		System.out.println("name=" + s1.name + " no=" + s1.no);
		System.out.println("name=" + s2.name + " no=" + s2.no);
	}
}
