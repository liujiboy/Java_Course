package code1002;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
public class AWTFrame extends Frame{
	private Button button=new Button("按键");
	public AWTFrame()
	{
		setSize(300,300);		//设置窗体大小
		setLocation(400, 400);	//设置窗体显示位置
		setTitle("AWTFrame");	//设置窗体标题栏
		//设置窗体关闭事件
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		setLayout(new FlowLayout());	//设置布局管理器
		//添加按键事件
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "点击了按键！");
			}
		});
		add(button);	//添加按键
	}
	public static void main(String[] args) {
		AWTFrame frame=new AWTFrame();	
		frame.setVisible(true);	//显示窗体		
	}
}
