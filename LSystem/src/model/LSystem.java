package model;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LSystem {
	private int number=3;
	private double angle=90;
	private String axiom="F+F+F+F";
	private String rule="FF+F+F+F+FF";
	private String state="";
	private double f=10;
	
	public String getState() {
		return state;
	}
	public double getF() {
		return f;
	}
	public void setF(double f) {
		this.f = f;
	}
	public void iterate()
	{
		state=axiom;
		for(int i=0;i<number;i++)
		{
			state=state.replaceAll("F", rule);
		}
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public String getAxiom() {
		return axiom;
	}
	public void setAxiom(String axiom) {
		this.axiom = axiom;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public static void main(String args[])
	{
		LSystem l=new LSystem();
		l.iterate();
		System.out.println(l.state);
		BufferedImage image=l.draw(500, 500);
		try {
			ImageIO.write(image, "jpeg", new File("a.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage draw(int width,int height) {
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2=(Graphics2D)image.getGraphics();
		Path2D path=new Path2D.Double();
		g2.setColor(Color.RED);
		BasicStroke stroke=new BasicStroke(3);
		g2.setStroke(stroke);
		Turtle t=new Turtle();
		path.moveTo(t.getX(), t.getY());
		for(int i=0;i<state.length();i++)
		{
			char c=state.charAt(i);
			switch(c){
			case 'F':

				t.forward(f);
				path.lineTo(t.getX(), t.getY());
				break;
			case 'f':
				t.forward(f);
				path.moveTo(t.getX(), t.getY());
				break;
			case '+':
				t.turnRight(angle);
				break;
			case '-':
				t.turnLeft(angle);
				break;
			case '[':
				t.startBranch();
				break;
			case ']':
				t.endBranch();
				path.moveTo(t.getX(), t.getY());
			}
		}
		AffineTransform at=new AffineTransform();
		//at.scale(width/path.getBounds2D().getWidth(),height/path.getBounds2D().getHeight());
		//at.translate(-path.getBounds2D().getX(), -path.getBounds2D().getY());
		at.translate(-path.getBounds2D().getX()+(width-path.getBounds2D().getWidth())/2, -path.getBounds2D().getY()+(height-path.getBounds2D().getHeight())/2);
		path.transform(at);
		g2.draw(path);
		return image;
	}
}
