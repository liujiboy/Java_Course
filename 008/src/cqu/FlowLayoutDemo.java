package cqu;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo extends JFrame {

	private static final long serialVersionUID = 6996154331811752247L;
	private JButton first=new JButton("first");
	private JButton second=new JButton("second");
	private JButton third=new JButton("third");
	public FlowLayoutDemo()
	{
		setLayout(new FlowLayout());
		add(first);
		add(second);
		add(third);
	}
	public static void main(String[] args) {
		FlowLayoutDemo demo=new FlowLayoutDemo();
		demo.setSize(400, 400);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
	}

}
