package code1007;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class ComplexLayoutDemo extends JFrame {
	private JPanel panel1=new JPanel();
	private JPanel panel2=new JPanel();
	private JPanel panel3=new JPanel();
	private JPanel panel4=new JPanel();
	public ComplexLayoutDemo()
	{
		setSize(500, 500);	
		setLocation(400, 400);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//对panel1进行布局
		layoutPanel1();
		//对panel2进行布局
		layoutPanel2();
		//对panel3进行布局
		layoutPanel3();
		//对panel4进行布局
		layoutPanel4();
		//对顶层容器进行布局,采用GridLayout，2行，2列
		setLayout(new GridLayout(2,2));
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
	}
	private void layoutPanel1() {
		JButton north = new JButton("北");
		JButton south = new JButton("南");
		JButton east = new JButton("东");
		JButton west = new JButton("西");
		JButton center = new JButton("中");
		//panel1采用BorderLayout布局
		panel1.setLayout(new BorderLayout());
		panel1.add(north,BorderLayout.NORTH);
		panel1.add(south,BorderLayout.SOUTH);
		panel1.add(east,BorderLayout.EAST);
		panel1.add(west,BorderLayout.WEST);
		panel1.add(center,BorderLayout.CENTER);
	}
	private void layoutPanel2() {
		JButton button1 = new JButton("按键1");
		JButton button2 = new JButton("按键2");
		JButton button3 = new JButton("按键3");
		JButton button4 = new JButton("按键4");
		//panel2采用FlowLayout布局
		panel2.setLayout(new FlowLayout());
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
	}
	private void layoutPanel3() {
		JButton button1 = new JButton("按键1");
		JButton button2 = new JButton("按键2");
		JButton button3 = new JButton("按键3");
		JButton button4 = new JButton("按键4");
		//panel3采用GridLayout布局，2行，2列
		panel3.setLayout(new GridLayout(2,2));
		panel3.add(button1);
		panel3.add(button2);
		panel3.add(button3);
		panel3.add(button4);
	}
	private void layoutPanel4() {
		JButton button=new JButton("按键");;
		JTextField textField=new JTextField("文本框");
		//panel2采用无布局管理器布局
		panel4.setLayout(null);
		button.setLocation(20, 20);
		button.setSize(100, 20);
		textField.setBounds(20,50,200,100);
		panel4.add(button);
		panel4.add(textField);
	}
	public static void main(String[] args) {
		ComplexLayoutDemo frame=new ComplexLayoutDemo();
		frame.setVisible(true);
	}
}

