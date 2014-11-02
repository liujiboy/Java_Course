

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.WindowConstants;
import javax.swing.JFrame;

import model.Game;

public class NewJPanel extends javax.swing.JPanel {
	Game game=new Game();
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400,700);
		frame.getContentPane().add(new NewJPanel());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public NewJPanel() {
		super();
		initGUI();
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_LEFT)
					game.getHero().setLeft(true);
				if(evt.getKeyCode()==KeyEvent.VK_RIGHT)
					game.getHero().setRight(true);
				if(evt.getKeyCode()==KeyEvent.VK_UP)
					game.getHero().setUp(true);
				if(evt.getKeyCode()==KeyEvent.VK_DOWN)
					game.getHero().setDown(true);
				if(evt.getKeyCode()==KeyEvent.VK_SPACE)
					game.shoot();
			}

			@Override
			public void keyReleased(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_LEFT)
					game.getHero().setLeft(false);
				if(evt.getKeyCode()==KeyEvent.VK_RIGHT)
					game.getHero().setRight(false);
				if(evt.getKeyCode()==KeyEvent.VK_UP)
					game.getHero().setUp(false);
				if(evt.getKeyCode()==KeyEvent.VK_DOWN)
					game.getHero().setDown(false);				
			}

			@Override
			public void keyTyped(KeyEvent evt) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.setFocusable(true);
		this.requestFocus();
		game.start();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(400, 700));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		game.draw(g);
		repaint(10);
	}

}
