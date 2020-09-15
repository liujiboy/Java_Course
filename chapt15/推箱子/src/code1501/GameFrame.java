package code1501;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class GameFrame extends JFrame {
	private Game game;
	private GameCanvas canvas;
	public GameFrame()
	{
		game=new Game();
		canvas=new GameCanvas(game);
		this.setLayout(new BorderLayout());
		this.add(canvas,BorderLayout.CENTER);
		this.setSize(256,275);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent event) {
				if(event.getKeyCode()==KeyEvent.VK_UP)
				{
					game.moveUp();
				}else if(event.getKeyCode()==KeyEvent.VK_DOWN)
				{
					game.moveDown();
				}else if(event.getKeyCode()==KeyEvent.VK_LEFT)
				{
					game.moveLeft();
				}else if(event.getKeyCode()==KeyEvent.VK_RIGHT)
				{
					game.moveRight();
				}
				canvas.repaint();
				if(game.isEnd())
					JOptionPane.showMessageDialog(null, "游戏结束");
			}
			public void keyReleased(KeyEvent event) {
			}
			public void keyTyped(KeyEvent event) {
			}
		});
	}
	public static void main(String[] args) {
		GameFrame frame=new GameFrame();
		frame.setVisible(true);
	}
}
