/**
 * 
 */
package code0507;

/**
 * Person.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
class Person {
	private String name;
	private int age;

	public Person() {
		this.name = "default";
	}
	public Person(String name) {
		this.name = name;
	}
	public Person(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		this.age = age;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String toString() {
		return "[" + this.name + "  " + this.age + "]";
	}
	public int addAge(int a){
		return age+a;
	}
}