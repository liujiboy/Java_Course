package edu.cqu;

public class Rect {
	private float width;
	private float height;
	public float getArea()
	{
		return width*height;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public Rect(float width, float height) {
		super();
		this.width = width;
		this.height = height;
	}
}
