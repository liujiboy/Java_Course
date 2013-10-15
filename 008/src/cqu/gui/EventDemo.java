package cqu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import edu.cqu.Point;
import edu.cqu.Triangle;

public class EventDemo extends JFrame  {

	private static final long serialVersionUID = -7294523685113290357L;
	private JPanel contentPane;
	private JTextField x1;
	private JTextField y1;
	private JTextField z1;
	private JTextField x2;
	private JTextField y2;
	private JTextField z2;
	private JTextField x3;
	private JTextField y3;
	private JTextField z3;
	private JTextArea message;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventDemo frame = new EventDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EventDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("点1：");
		
		JLabel label_1 = new JLabel("点2：");
		
		JLabel label_2 = new JLabel("点3：");
		
		x1 = new JTextField();
		x1.setColumns(10);
		
		y1 = new JTextField();
		y1.setColumns(10);
		
		z1 = new JTextField();
		z1.setColumns(10);
		
		x2 = new JTextField();
		x2.setColumns(10);
		
		y2 = new JTextField();
		y2.setColumns(10);
		
		z2 = new JTextField();
		z2.setColumns(10);
		
		x3 = new JTextField();
		x3.setColumns(10);
		
		y3 = new JTextField();
		y3.setColumns(10);
		
		z3 = new JTextField();
		z3.setColumns(10);
		
		JButton compute = new JButton("计算");
		compute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p1=new Point(Double.parseDouble(x1.getText()),Double.parseDouble(y1.getText()),Double.parseDouble(z1.getText()));
				Point p2=new Point(Double.parseDouble(x2.getText()),Double.parseDouble(y2.getText()),Double.parseDouble(z2.getText()));
				Point p3=new Point(Double.parseDouble(x3.getText()),Double.parseDouble(y3.getText()),Double.parseDouble(z3.getText()));
				try {
					Triangle t=new Triangle(p1,p2,p3);
					double area=t.getArea();
					double length=t.getLength();
					message.setText("面积："+area+",周长："+length);
				} catch (Exception e1) {
					message.setText("不是三角形");
					e1.printStackTrace();
				}
			}
		});
		
		message = new JTextArea();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(message, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(x3, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(x2, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(x1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(y3, 0, 0, Short.MAX_VALUE)
								.addComponent(y2, 0, 0, Short.MAX_VALUE)
								.addComponent(y1, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(z3, 0, 0, Short.MAX_VALUE)
								.addComponent(z2, 0, 0, Short.MAX_VALUE)
								.addComponent(z1, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(compute, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(x1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(y1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(z1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(compute))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(x2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(y2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(z2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(x3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(y3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(z3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(message, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
