package cqu.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	private static final long serialVersionUID = 8604233370913902709L;
	private int x=0;
	private int y=0;
	/**
	 * Create the panel.
	 */
	public PaintPanel() {
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key pressed");
				switch(e.getKeyCode())
				{
				case KeyEvent.VK_UP:
					y--;
					break;
				case KeyEvent.VK_DOWN:
					y++;
					break;
				case KeyEvent.VK_LEFT:
					x--;
					break;
				case KeyEvent.VK_RIGHT:
					x++;
					break;
				}
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
		});
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.fillRect(x, y, 200, 200);
	}
}
