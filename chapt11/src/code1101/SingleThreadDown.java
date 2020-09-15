/**
 * 
 */
package code1101;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * SingleThreadDown.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */

public class SingleThreadDown extends JFrame implements ActionListener {
	private final JPanel panel = new JPanel();
	private final JLabel label1 = new JLabel("网络资源的单线程下载：");
	private final JLabel label2 = new JLabel("网络资源的网址：");
	JButton StartButton = new JButton("点击开始下载");
	JButton resetButton = new JButton("清空");
	JButton exitButton = new JButton("退出");
	JTextField urlField = new JTextField(20);

	public SingleThreadDown() {
		panel.setLayout(new FlowLayout());
		label1.setFont(new Font("雅黑", Font.BOLD, 15));
		panel.add(label1);
		panel.add(label2);
		panel.add(urlField);
		panel.add(StartButton);
		panel.add(resetButton);
		panel.add(exitButton);
		setContentPane(panel);
		StartButton.addActionListener(this);
		resetButton.addActionListener(this);
		exitButton.addActionListener(this);
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void download(String address) throws Exception {
		URL url = new URL(address);
		URLConnection urlcon = url.openConnection();
		urlcon.connect();
		InputStream in = urlcon.getInputStream();
		String filePath = url.getFile();
		int pos = filePath.lastIndexOf("/");
		String fileName = filePath.substring(pos + 1);
		FileOutputStream out = new FileOutputStream("D:\\" + fileName);
		byte[] bytes = new byte[1024];
		int len = in.read();
		while (len != -1) {
			out.write(bytes, 0, len);
			len = in.read();
		}
		out.close();
		in.close();
		JOptionPane.showMessageDialog(this, "下载完毕");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == StartButton) {
			if ("".equals(urlField.getText())) {
				JOptionPane.showMessageDialog(this, "请输入资源地址");
			}
			String url = urlField.getText();
			try {
				download(url);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "资源地址有误，请检查，谢谢！");
				e1.printStackTrace();
			}
		} else if (e.getSource() == resetButton) {
			urlField.setText("");
		} else {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new SingleThreadDown();
	}

}