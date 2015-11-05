package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.LSystem;


public class ImageCanvas extends JPanel {
	private LSystem	l;
	

	public void setL(LSystem l) {
		this.l = l;
	}


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(l!=null)
		{
			System.out.println(this.getHeight());
			BufferedImage image=l.draw(this.getWidth(), this.getHeight());
			g.drawImage(image, 0, 0, null);
		}
	}

}
