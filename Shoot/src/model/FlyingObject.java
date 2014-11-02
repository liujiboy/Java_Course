package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FlyingObject {
	private int x;
	private int y;
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private int speed = 1;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	private BufferedImage image;

	public void move() {
		
			if (left)
				x--;
			if (right)
				x++;
			if (up)
				y--;
			if (down)
				y++;
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}
	public boolean collide(FlyingObject other)
	{
		int x=this.x;
		int y=this.y;
		int x1=other.x;
		int y1=other.y;
		int a=this.x+this.getImage().getWidth();
		int b=this.y+this.getImage().getHeight();
		int a1=other.x+other.getImage().getWidth();
		int b1=other.y+other.getImage().getHeight();
		if(a<x1||a1<x)
		{
			//肯定不相交
			return false;
		}
		if(b<y1||b1<y)
		{
			//肯定不相交
			return false;
		}
		return true;
	}
}
