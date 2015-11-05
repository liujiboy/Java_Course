package gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import model.Game;

public class GameCanvas extends JPanel {
	private Game game=new Game();
	public GameCanvas()
	{
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
	public void paint(Graphics g)
	{
		super.paint(g);
		game.draw(g);
		repaint(10);
	}
}
