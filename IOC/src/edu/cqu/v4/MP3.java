package edu.cqu.v4;

import edu.cqu.v4.annotation.Component;

@Component(name="mp3")
public class MP3 implements USB{

	@Override
	public void read() {
		System.out.println("mp3 read");
	}

	

}
