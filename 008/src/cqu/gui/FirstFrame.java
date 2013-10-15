package cqu.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstFrame {
	public  static void main(String args[])
	{
		JFrame frame=new JFrame("FirstFrame");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		JButton button=new JButton("ok");
		button.setLocation(200, 200);
		button.setSize(40, 20);
		frame.add(button);
		frame.setVisible(true);
	}
}
