package cqu;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutDemo extends JFrame {

	private static final long serialVersionUID = 2663941158824082918L;
	private JButton north=new JButton("north");
	private JButton south=new JButton("south");
	private JButton east=new JButton("east");
	private JButton west=new JButton("west");
	private JButton center=new JButton("center");
	public GridLayoutDemo()
	{
		setLayout(new GridLayout(3,2));
		add(north);
		add(south);
		add(east);
		add(west);
		add(center);
	}
	public static void main(String[] args) {
		GridLayoutDemo demo=new GridLayoutDemo();
		demo.setSize(400, 400);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
	}

}
