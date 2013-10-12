package cqu;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo extends JFrame{

	private static final long serialVersionUID = 1326775352586027025L;
	private JButton north=new JButton("north");
	private JButton south=new JButton("south");
	private JButton east=new JButton("east");
	private JButton west=new JButton("west");
	private JButton center=new JButton("center");
	public BorderLayoutDemo()
	{
		setLayout(new BorderLayout());
		add(north,BorderLayout.NORTH);
		add(south,BorderLayout.SOUTH);
		add(east,BorderLayout.EAST);
		add(west,BorderLayout.WEST);
		add(center,BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		BorderLayoutDemo demo=new BorderLayoutDemo();
		demo.setSize(400, 400);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
	}


}
