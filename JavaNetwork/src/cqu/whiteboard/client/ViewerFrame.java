package cqu.whiteboard.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ViewerFrame extends JFrame {
	private static final long serialVersionUID = 1460061072792905284L;
	private ViewerCanvas canvas;
	public ViewerFrame()
	{
		canvas=new ViewerCanvas();
		this.setTitle("ViewerFrame");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(canvas,BorderLayout.CENTER);
	}
	public static void main(String args[])
	{
		ViewerFrame frame=new ViewerFrame();
		frame.setVisible(true);
	}
}
