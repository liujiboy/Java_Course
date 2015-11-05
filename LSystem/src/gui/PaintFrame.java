package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import model.LSystem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaintFrame extends JFrame {

	private JPanel contentPane;
	private JTextField axiomField;
	private JLabel label_1;
	private JTextField ruleField;
	private JLabel label_2;
	private JTextField angleField;
	private JLabel label_3;
	private JTextField numField;
	private JLabel label_4;
	private JTextField fField;
	private ImageCanvas imageCanvas ;
	private JTextArea textArea;
	private LSystem l=new LSystem();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaintFrame frame = new PaintFrame();
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
	public PaintFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("初始状态：");
		
		axiomField = new JTextField();
		axiomField.setColumns(10);
		axiomField.setText(l.getAxiom());
		label_1 = new JLabel("迭代规则：");
		
		ruleField = new JTextField();
		ruleField.setColumns(10);
		ruleField.setText(l.getRule());
		label_2 = new JLabel("角度：");
		
		angleField = new JTextField();
		angleField.setColumns(10);
		angleField.setText(String.valueOf(l.getAngle()));
		label_3 = new JLabel("次数：");
		
		numField = new JTextField();
		numField.setColumns(10);
		numField.setText(String.valueOf(l.getNumber()));
		label_4 = new JLabel("步长：");
		
		fField = new JTextField();
		fField.setColumns(10);
		fField.setText(String.valueOf(l.getF()));
		JButton button = new JButton("绘制");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l.setAxiom(axiomField.getText());
				l.setRule(ruleField.getText());
				l.setAngle(Double.valueOf(angleField.getText()));
				l.setNumber(Integer.valueOf(numField.getText()));
				l.setF(Double.valueOf(fField.getText()));
				l.iterate();
				textArea.setText(l.getState());
				imageCanvas.setL(l);
				imageCanvas.repaint();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "\u5F53\u524D\u72B6\u6001", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		imageCanvas = new ImageCanvas();
		imageCanvas.setBorder(new TitledBorder(null, "\u8F93\u51FA\u56FE\u50CF", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(axiomField, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_2)
										.addComponent(label_1))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(ruleField, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
													.addGap(179)
													.addComponent(imageCanvas, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
												.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
													.addComponent(angleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(35)
													.addComponent(label_3)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(numField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(label_4)
													.addGap(18)
													.addComponent(fField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(53)
													.addComponent(button)))
											.addGap(0)))))
							.addGap(28))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(axiomField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(ruleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(angleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(numField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(fField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(imageCanvas, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
					.addGap(16))
		);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}
}
