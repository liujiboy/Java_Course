package code1004;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class FlowLayoutDemo extends JFrame {
	private JButton button1 = new JButton("First Button");
	private JButton button2 = new JButton("Second Button");
	private JButton button3 = new JButton("Third Button");
	private JButton button4 = new JButton("Fourth Button");
	public FlowLayoutDemo() {
		setSize(300, 150);
		setLocation(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局方式为FlowLayout
		setLayout(new FlowLayout());
		//添加按键，注意设置布局方式之后任何对
		//组件进行设置的方法，例如setSize、
		//setLocation等都会失效
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	}
	public static void main(String arg[]) {
		FlowLayoutDemo frame = new FlowLayoutDemo();
		frame.setVisible(true);
	}
}
