package cqu.calculator.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import cqu.calculator.model.Calculator;


public class CalculatorFrame extends JFrame implements ActionListener{
	private JPanel buttonPanel=new JPanel();
	private JPanel numberPanel=new JPanel();
	private JPanel operatorPanel=new JPanel();
	private JLabel display=new JLabel("0.0",JLabel.RIGHT);
	private JButton clearBt=new JButton("C");
	private JButton dotBt=new JButton(".");
	private JButton numberBt[]=new JButton[10];
	private JButton operatorBt[]=new JButton[5];
	private Calculator cal=new Calculator();
	public CalculatorFrame()
	{
		this.setTitle("计算器");
		
		this.setLayout(new BorderLayout());
		//display.setBounds(50, 50, 200, 200);
		display.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
		display.setPreferredSize(new Dimension(0,60));
		this.add(display,BorderLayout.NORTH);
		layoutButtonPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(buttonPanel,BorderLayout.CENTER);
		
	}
	private void layoutButtonPanel() {
		buttonPanel.setLayout(new BorderLayout());
		layoutNumberPanel();
		buttonPanel.add(numberPanel,BorderLayout.CENTER);
		layoutOperatorPanel();
		buttonPanel.add(operatorPanel,BorderLayout.EAST);
	}
	private void layoutOperatorPanel() {
		operatorPanel.setLayout(new GridLayout(5,1,5,5));
		String operators[]={"+","-","*","/","="};
		for(int i=0;i<operators.length;i++)
		{
			operatorBt[i]=new JButton(operators[i]);
			operatorBt[i].addActionListener(this);
			operatorPanel.add(operatorBt[i]);
		}
	}
	private void layoutNumberPanel() {
		numberPanel.setLayout(new GridLayout(4,3,5,5));
		for(int i=0;i<10;i++)
		{
			numberBt[i]=new JButton(String.valueOf(i));
			numberBt[i].addActionListener(this);
			numberPanel.add(numberBt[i]);
		}
		dotBt.addActionListener(this);
		numberPanel.add(dotBt);
		clearBt.addActionListener(this);
		numberPanel.add(clearBt);
	}
	public static void main(String[] args) {
		CalculatorFrame frame=new CalculatorFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bt=(JButton) e.getSource();
		Double displayValue=cal.readInput(bt.getText().charAt(0));
		display.setText(displayValue.toString());
	}

}
