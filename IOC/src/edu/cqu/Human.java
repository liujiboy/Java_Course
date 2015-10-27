package edu.cqu;

public class Human {

	public static void main(String[] args) {
		Computer c=new Computer();
		c.setUSB(new MP3());
		c.readFromUSB();
		c.setUSB(new Camera());
		c.readFromUSB();
		c.setUSB(new Disk());
		c.readFromUSB();
		c.setUSB(new Scanner());
		c.readFromUSB();
	}

}
