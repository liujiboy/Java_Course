package edu.cqu.v4;

import edu.cqu.v4.annotation.Component;

@Component(name="scanner")
public class Scanner implements USB {

	@Override
	public void read() {
		System.out.println("Scanner read");

	}

}
