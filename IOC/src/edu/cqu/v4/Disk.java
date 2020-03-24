package edu.cqu.v4;

import edu.cqu.v4.annotation.Component;

@Component(name="disk")
public class Disk implements USB{
	public void read() {
		System.out.println("disk read");
	}
}
