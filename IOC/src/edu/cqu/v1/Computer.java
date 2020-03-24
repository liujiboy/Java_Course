package edu.cqu.v1;

public class Computer {
	private Camera camera=new Camera();
	private Disk disk=new Disk();
	private MP3 mp3=new MP3();
	public void readFromCamera()
	{
		camera.read();
	}
	public void readFromDisk()
	{
		disk.read();
	}
	public void readFromMP3()
	{
		mp3.read();
	}
}
