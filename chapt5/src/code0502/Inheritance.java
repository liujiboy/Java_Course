/**
 * 
 */
package code0502;

/**
 * Inheritance.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
class Employee {
	private String name;
	private int salary;

	public String getDetails() {
		return "Name:" + name + "\nSalary:" + salary;
	}

	Employee() {
		name = "Tom";
		salary = 1234;
	}
	
}

// 定义经理类
class Manager extends Employee {
	public String department;
	/* 重写getDetails方法 */
	public String getDetails() {
		System.out.println("I am in Manager");
		return super.getDetails(); // 调用父类的getDetails方法
	}

	Manager() {
		super(); // 访问父类的无参构造方法,即Employee()
		department = "sale";
	}
}

public class Inheritance {
	public static void main(String arg[]) {
		Manager m = new Manager();
		System.out.println(m.getDetails());
		System.out.println("department:" + m.department);
	}
}
