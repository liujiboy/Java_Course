package edu.cqu.v3;

public class Human {

	public static void main(String[] args) {
		ApplicationContex context=new ApplicationContex("/edu/cqu/v3/beans.xml");
		Computer c=(Computer) context.getBean("computer");
		c.readFromUSB();
		
	}

}
