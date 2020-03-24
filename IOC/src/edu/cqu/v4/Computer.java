package edu.cqu.v4;

import edu.cqu.v4.annotation.Autowired;
import edu.cqu.v4.annotation.Component;

@Component(name="computer")
public class Computer {
	@Autowired(name="scanner")
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
