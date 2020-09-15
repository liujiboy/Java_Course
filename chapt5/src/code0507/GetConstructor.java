/**
 * 
 */
package code0507;

import java.lang.reflect.Constructor;

/**
 * GetConstructor.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */



public class GetConstructor {
	public static void main(String[] args) {
		Class<?> demo = null;
		try {
			demo = Class.forName("code0507.Person");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 取得全部的构造函数
		Constructor<?> cons[] = demo.getConstructors();
		try {
			Constructor cons0 = demo.getConstructor();  
            Constructor cons1 = demo.getConstructor(String.class);  
            Constructor cons2 = demo.getConstructor(int.class);  
            Constructor cons3 = demo.getConstructor(String.class,int.class);  
            Person per1 = (Person) cons0.newInstance();
            Person per2 = (Person) cons1.newInstance("ZhangShan");
            Person per3 = (Person) cons2.newInstance(20);
            Person per4 = (Person) cons3.newInstance("Lisi", 20);
    		System.out.println(per1);// [default 0]
    		System.out.println(per2);// [ZhangShan 0]
    		System.out.println(per3);// [null 20]
    		System.out.println(per4);// [Lisi 20]
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}