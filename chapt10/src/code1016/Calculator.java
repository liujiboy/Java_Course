package code1016;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Calculator extends JFrame implements ActionListener {
	private JPanel centerPanel = new JPanel();
	private String x = "";
	private String y = "";
	private String fh = "";
	private double answer;
	private JTextField tfAnswer; 

	public Calculator() {
		this.setBackground(Color.lightGray); 
		setLayout(new BorderLayout());
		tfAnswer = new JTextField();
		tfAnswer.setHorizontalAlignment(JTextField.RIGHT);
		tfAnswer.setText("0.");
		add(tfAnswer, BorderLayout.NORTH);

		centerPanel.setLayout(new GridLayout(5, 5));
		addButton("7", Color.blue);
		addButton( "8", Color.blue);
		addButton( "9", Color.blue);
		addButton( "/", Color.red);
		addButton( "C", Color.red);
		addButton( "4", Color.blue);
		addButton( "5", Color.blue);
		addButton( "6", Color.blue);
		addButton( "*", Color.red);
		addButton( "^", Color.blue);
		addButton( "1", Color.blue);
		addButton( "2", Color.blue);
		addButton( "3", Color.blue);
		addButton( "-", Color.red);
		addButton( "sqrt", Color.blue);
		addButton( "0", Color.blue);
		addButton( "+/-", Color.blue);
		addButton( ".", Color.blue);
		addButton( "+", Color.red);
		addButton( "=", Color.red);
		addButton( "sin", Color.red);
		addButton( "cos", Color.red);
		addButton( "tan", Color.red);
		addButton( "ln", Color.red);
		add(centerPanel, BorderLayout.CENTER);
	}

	
	public void addButton(String name, Color color) {
		
		JButton bt = new JButton(name);
		bt.setBackground(Color.white);
		bt.setForeground(color);
		bt.addActionListener(this);
		centerPanel.add(bt);
	}

	// 计算功能实现
	public void dengyu(String z) {
		if (z.equals("+"))
			answer = Double.parseDouble(x) + Double.parseDouble(y);
		if (z.equals("-"))
			answer = Double.parseDouble(x) - Double.parseDouble(y);
		if (z.equals("*"))
			answer = Double.parseDouble(x) * Double.parseDouble(y);
		if (z.equals("/"))
			answer = Double.parseDouble(x) / Double.parseDouble(y);
		if (z.equals("^"))
			answer = Math.pow(Double.parseDouble(x), Double.parseDouble(y));
		if (z.equals("sin"))
			answer = Math.sin(Double.parseDouble(x));
		if (z.equals("cos"))
			answer = Math.cos(Double.parseDouble(x));
		if (z.equals("tan"))
			answer = Math.tan(Double.parseDouble(x));
		if (z.equals("ln"))
			answer = Math.log(Double.parseDouble(x));
		x = Double.toString(answer);
		tfAnswer.setText(x);
		y = "";
		fh = "";
	}

	public void actionPerformed(ActionEvent e) throws IndexOutOfBoundsException {
		if (e.getActionCommand().equals("0")
				|| e.getActionCommand().equals("1")
				|| e.getActionCommand().equals("2")
				|| e.getActionCommand().equals("3")
				|| e.getActionCommand().equals("4")
				|| e.getActionCommand().equals("5")
				|| e.getActionCommand().equals("6")
				|| e.getActionCommand().equals("7")
				|| e.getActionCommand().equals("8")
				|| e.getActionCommand().equals("9")) {
			if (fh.equals("")) {
				x = x + e.getActionCommand();
				if (x.startsWith("00")) {
					x = x.substring(1);
				}
				tfAnswer.setText(x);
			} else {
				y = y + e.getActionCommand();
				if (y.startsWith("00")) {
					y = y.substring(1);
				}
				tfAnswer.setText(y);
			}
		}

		if (e.getActionCommand().equals(".")) {
			if (fh.equals("")) {
				int i = 0, j = 0;
				for (i = 0; i < x.length(); i++)
					if (x.charAt(i) == '.')
						j++;
				if (j == 0)
					x = x + ".";
				tfAnswer.setText(x);
			} else {
				int i = 0, j = 0;
				for (i = 0; i < y.length(); i++)
					if (y.charAt(i) == '.')
						j++;
				if (j == 0)
					y = y + ".";
				tfAnswer.setText(y);
			}
		}

		if (e.getActionCommand().equals("C")) {
			x = "";
			y = "";
			fh = "";
			tfAnswer.setText("0.");
		}

		if (e.getActionCommand().equals("+/-")) {
			if (fh.equals("")) {
				if (x.substring(0, 1).equals("-"))
					x = x.substring(1);
				else
					x = "-" + x;
				tfAnswer.setText(x);
			} else {
				if (y.substring(0, 1).equals("-"))
					y = y.substring(1);
				else
					y = "-" + y;
				tfAnswer.setText(y);
			}
		}

		if (e.getActionCommand().equals("sqrt")) {
			if (fh != "")
				dengyu(fh);
			answer = Math.sqrt(Double.parseDouble(x));
			x = Double.toString(answer);
			tfAnswer.setText(x);
		}

		if (e.getActionCommand().equals("+")) {
			if (fh != "")
				dengyu(fh);
			fh = "+";
		}
		if (e.getActionCommand().equals("-")) {
			if (fh != "")
				dengyu(fh);
			fh = "-";
		}
		if (e.getActionCommand().equals("*")) {
			if (fh != "")
				dengyu(fh);
			fh = "*";
		}
		if (e.getActionCommand().equals("/")) {
			if (fh != "")
				dengyu(fh);
			fh = "/";
		}
		if (e.getActionCommand().equals("^")) {
			if (fh != "")
				dengyu(fh);
			fh = "^";
		}
		if (e.getActionCommand().equals("sin")) {
			if (fh != "")
				dengyu(fh);
			answer = Math.sin(Double.parseDouble(x));
			x = Double.toString(answer);
			tfAnswer.setText(x);
		}
		if (e.getActionCommand().equals("cos")) {
			if (fh != "")
				dengyu(fh);
			answer = Math.cos(Double.parseDouble(x));
			x = Double.toString(answer);
			tfAnswer.setText(x);
		}
		if (e.getActionCommand().equals("tan")) {
			if (fh != "")
				dengyu(fh);
			answer = Math.tan(Double.parseDouble(x));
			x = Double.toString(answer);
			tfAnswer.setText(x);
		}
		if (e.getActionCommand().equals("ln")) {
			if (fh != "")
				dengyu(fh);
			answer = Math.log(Double.parseDouble(x));
			x = Double.toString(answer);
			tfAnswer.setText(x);
		}
		if (e.getActionCommand().equals("="))
			dengyu(fh);
	}

	public static void main(String args[]) {
		Calculator c = new Calculator();
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setSize(400, 400);
		c.setVisible(true);
	}
}
