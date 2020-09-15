/**
 * 
 */
package code0506;

import javax.swing.*;
import java.awt.event.*;

/**
 * QFrame.java Copyright (c) 2016 ChongQing University All rights reserved.
 */

public class QFrame extends JFrame {
	public QFrame() {
		JButton jbtNew = new JButton("New");
		JPanel panel = new JPanel();
		panel.add(jbtNew);
		add(panel);
		jbtNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "点击了新建按钮");
				System.out.println("Process new");
			}
		});
	}

	public static void main(String[] args) {
		JFrame frame = new QFrame();
		frame.setTitle("QFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
}
