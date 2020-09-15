/**
 * 
 */
package code0507;

/**
 * GetClass.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class GetClass {
	public static void main(String[] args) {
		checkClass();
	}

	public static void checkClass() {
		try {
			System.out.println("使用对象的getClass方法");
			Class cla= new Student().getClass();
			System.out.println(cla.getName());

			System.out.println("使用类名.class方法");
			Class forClass = Student.class;
			System.out.println(forClass.getName());

			System.out.println("使用Class类的静态方法");
			Class forName = Class.forName("code0507.Student");
			System.out.println(forName.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class Student {
	private int id;
	private String name;
	public Student() {
		id=0;
		name="default";
	}
}