/**
 * 
 */
package code0404;

/**
 * Student.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
class Student{
	int no;
	String name;
	Student(int l_no, String l_name){      //定义构造方法
		this.no=l_no; this.name=l_name;         //对成员变量no,name初始化
	}
	public static void main(String args[]){
		Student s1=new Student(1,"zhangShan");  //传递参数 l_no=1;l_name= zhangShan
		Student s2=new Student(2,"xiaoMing");   //传递参数 l_no=2;l_name= xiaoMing
		System.out.println("name="+s1.name+" no="+s1.no);
		System. out.println("name="+s2.name+" no="+s2.no);
	}
}
