package cqu.whiteboard.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PainterFrame extends JFrame {
	private static final long serialVersionUID = -6563428753686312364L;
	private PainterCanvas canvas;
	public PainterFrame()
	{
		canvas=new PainterCanvas();
		this.setTitle("PaintFrame");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(canvas,BorderLayout.CENTER);
	}
	public static void main(String args[])
	{
		PainterFrame frame=new PainterFrame();
		frame.setVisible(true);
	}
}
