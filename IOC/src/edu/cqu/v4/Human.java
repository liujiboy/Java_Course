package edu.cqu.v4;

public class Human {

	public static void main(String[] args) {
		ApplicationContex context=new ApplicationContex();
		Computer c=(Computer) context.getBean("computer");
		c.readFromUSB();
		
	}

}
