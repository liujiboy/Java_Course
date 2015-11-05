package gui;


import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class MainFrame extends JFrame {
	public MainFrame()
	{
		setSize(400,700);
		add(new GameCanvas());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		MainFrame frame=new MainFrame();
		frame.setVisible(true);

	}

}
