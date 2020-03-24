package edu.cqu.v3;

public class Computer {
	private USB usb;
	public void readFromUSB()
	{
		usb.read();
	}
	public void setUSB(USB usb)
	{
		this.usb=usb;
	}
}
