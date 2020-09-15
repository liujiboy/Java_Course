/**
 * 
 */
package code0507;

/**
 * WildCardTest.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
public class WildCardTest {
	public static void main(String[] args) {
		Box<String> name = new Box<String>("Hello");
		Box<Integer> age = new Box<Integer>(12);
		Box<Double> number = new Box<Double>(210.50);
		getData(name);
		getData(age);
		getData(number);
	}

	public static void getData(Box<?> data) {
		System.out.println("data :" + data.getData());
	}
}

class Box<T> {
	private T data;
	public Box() {	}

	public Box(T data) {
		setData(data);
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
