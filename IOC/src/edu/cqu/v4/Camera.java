package edu.cqu.v4;

import edu.cqu.v4.annotation.Component;

@Component(name="camera")
public class Camera implements USB{
	public void read() {
		System.out.println("camera read");
	}
}
