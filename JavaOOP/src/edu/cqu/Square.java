package edu.cqu;

public class Square {
	private Rect rect;
	private Square(float l) {
		this.rect=new Rect(l,l);
	}
	public float getL()
	{
		return rect.getWidth();
	}
	public float getArea()
	{
		return rect.getArea();
	}
}
