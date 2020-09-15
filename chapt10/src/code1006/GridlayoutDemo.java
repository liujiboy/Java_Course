package code1006;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class GridlayoutDemo extends JFrame {
	private JButton button1 = new JButton("按键1");
	private JButton button2 = new JButton("按键2");
	private JButton button3 = new JButton("按键3");
	private JButton button4 = new JButton("按键4");
	public GridlayoutDemo() {
		setSize(300, 300);
		setLocation(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局方式为GridLayout,2行，2列
		setLayout(new GridLayout(2,2));
		//添加组件时不需要设置组件所在行、列
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	}
	public static void main(String arg[]) {
		GridlayoutDemo frame = new GridlayoutDemo();
		frame.setVisible(true);
	}
}
