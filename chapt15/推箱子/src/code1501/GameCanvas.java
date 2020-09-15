package code1501;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class GameCanvas extends JPanel {
	//箱子图片
	private  BufferedImage box;
	//空地图片
	private  BufferedImage empty;
	//角色图片
	private BufferedImage hero;
	//目标图片
	private BufferedImage target;
	//墙图片
	private BufferedImage wall;

	private Game game;
	public GameCanvas(Game game)
	{
		this.game=game;
		try {
			box=ImageIO.read(new File("box.png"));
			empty=ImageIO.read(new File("empty.png"));
			hero=ImageIO.read(new File("hero.png"));
			target=ImageIO.read(new File("target.png"));
			wall=ImageIO.read(new File("wall.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//绘制游戏界面
	public void paint(Graphics g) {
		super.paint(g);
		BufferedImage image=null;
		for(int j=0;j<8;j++)
			for(int i=0;i<8;i++)
			{
				if(game.getMap()[i][j].equals("B"))
				{
					image=box;
				}else if(game.getMap()[i][j].equals("E"))
				{
					image=empty;
				}else if(game.getMap()[i][j].equals("H"))
				{
					image=hero;
				}else if(game.getMap()[i][j].equals("T"))
				{
					image=target;
				}else if(game.getMap()[i][j].equals("W"))
				{
					image=wall;
				}
				g.drawImage(image, 0+i*image.getWidth(), 0+j*image.getHeight(),null);
			}
	}
}
