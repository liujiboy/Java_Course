package code1003;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class AbsoluteLayoutDemo extends JFrame {
	private JButton button=new JButton("按键");;
	private JTextField textField=new JTextField("文本框");
	public AbsoluteLayoutDemo()
	{	
		setSize(500, 200);	
		setLocation(400, 400);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局管理为null
		setLayout(null);
		//设置输入框的位置为(20,20)，宽200，高100
		textField.setBounds(20,20,200,100);
		add(textField);
		//设置按键的位置为(300,50)，宽100，高20
		button.setLocation(300, 50);
		button.setSize(100, 20);
		add(button);
	}
	public static void main(String[] args) {
		AbsoluteLayoutDemo frame=new AbsoluteLayoutDemo();
		frame.setVisible(true);
	}
}

