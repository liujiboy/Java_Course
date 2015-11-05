package model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Stack;

public class Turtle {
	private double x=0;
	private double y=0;
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	private double dx=1;
	private double dy=0;
	private Stack<Turtle> stack=new Stack<Turtle>();
	public Turtle(double x, double y, double dx, double dy) {
		super();
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
	}
	public Turtle(Turtle t)
	{
		this(t.x,t.y,t.dx,t.dy);
	}
	
	public Turtle() {
		super();
	}
	public void forward(double d)
	{
		x=x+d*dx;
		y=y+d*dy;
	}
	public void turnRight(double degree)
	{
		turnLeft(-degree);
	}
	public void turnLeft(double degree)
	{
		double cos=Math.cos(Math.toRadians(degree));
		double sin=Math.sin(Math.toRadians(degree));
		double dx1=dx;
		double dy1=dy;
		dx=dx1*cos-dy1*sin;
		dy=dx1*sin+dy1*cos;
	}
	public void startBranch()
	{
		stack.push(new Turtle(this));
	}
	public void endBranch()
	{
		Turtle t= stack.pop();
		this.x=t.x;
		this.y=t.y;
		this.dx=t.dx;
		this.dy=t.dy;
	}
	public String toString()
	{
		StringWriter sw=new StringWriter();
		PrintWriter writer=new PrintWriter(sw);
		writer.printf("位置：(%f,%f)方向(%f,%f)", x,y,dx,dy);
		writer.close();
		return sw.toString();
		
	}
	public static void main(String args[])
	{
		Turtle t=new Turtle();
		System.out.println(t);
		t.turnLeft(45);
		System.out.println(t);
		t.turnRight(45);
		System.out.println(t);
		t.turnLeft(45);
		t.forward(1);
		System.out.println(t);
		t.startBranch();
		t.forward(2);
		System.out.println(t);
		t.endBranch();
		System.out.println(t);
	}
}
