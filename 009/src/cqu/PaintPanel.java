package cqu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	private static final long serialVersionUID = 8604233370913902709L;
	private int x=0;
	private int y=0;
	private int xDirection=1;
	private int yDirection=0;
	/**
	 * Create the panel.
	 */
	public PaintPanel() {
		Thread t=new Thread()
		{
			public void run()
			{
				while(true)
				{
					x+=xDirection;
					y+=yDirection;
					//xDirection=0;
					//yDirection=0;
					repaint();
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				switch(e.getKeyCode())
				{
				case KeyEvent.VK_UP:
					yDirection=-1;
					break;
				case KeyEvent.VK_DOWN:
					yDirection=1;
					break;
				case KeyEvent.VK_LEFT:
					xDirection=-1;
					break;
				case KeyEvent.VK_RIGHT:
					xDirection=1;
					break;
				}
				//repaint();
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
