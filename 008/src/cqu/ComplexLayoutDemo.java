package cqu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComplexLayoutDemo extends JFrame{

	private static final long serialVersionUID = -6700565162528866686L;
	private JPanel centerPanel=new JPanel();
	private JPanel leftPanel=new JPanel();
	private JPanel rightPanel=new JPanel();
	private JButton first=new JButton("first");
	private JButton second=new JButton("second");
	private JButton third=new JButton("third");
	private JButton north=new JButton("north");
	private JButton south=new JButton("south");
	private JButton east=new JButton("east");
	private JButton west=new JButton("west");
	private JButton center=new JButton("center");
	public ComplexLayoutDemo()
	{
		setLayout(new BorderLayout());
		this.add(centerPanel,BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(1,2));
		centerPanel.add(leftPanel);
		centerPanel.add(rightPanel);
		leftPanel.setLayout(new FlowLayout());
		leftPanel.add(first);
		leftPanel.add(second);
		leftPanel.add(third);
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(north,BorderLayout.NORTH);
		rightPanel.add(south,BorderLayout.SOUTH);
		rightPanel.add(east,BorderLayout.EAST);
		rightPanel.add(west,BorderLayout.WEST);
		rightPanel.add(center,BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		ComplexLayoutDemo demo=new ComplexLayoutDemo();
		demo.setSize(400, 400);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
	}

}
