package model;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Game extends Thread {
	private List<FlyingObject> enemies = new CopyOnWriteArrayList<FlyingObject>();
	private List<FlyingObject> bullets = new CopyOnWriteArrayList<FlyingObject>();
	private List<FlyingObject> myBullets = new CopyOnWriteArrayList<FlyingObject>();
	private FlyingObject hero = new FlyingObject();

	public Game() {
		hero.setX(100);
		hero.setY(500);
		hero.setSpeed(5);
		try {
			hero.setImage(ImageIO.read(Game.class
					.getResourceAsStream("/images/hero.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		int time = 0;
		while (true) {
			time++;
			//添加敌机
			addEnemy(time);
			//敌机发射子弹
			enemiesShoot(time);
			//敌机移动
			enemiesMove(time);
			//子弹移动
			bulletsMove(time);
			//我方子弹移动
			myBulletsMove(time);
			//主角移动
			heroMove(time);
			// 检测敌机与子弹的碰撞
			collideWithMyBullets();
			// 检测主角与子弹的碰撞
			collideWithHero();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private void collideWithHero() {
		for (FlyingObject bullet : bullets) {
			if (hero.collide(bullet)) {

				JOptionPane.showMessageDialog(null, "游戏结束");
				System.exit(0);

			}
		}
	}

	private void collideWithMyBullets() {
		List<FlyingObject> removedEnemies = new ArrayList<FlyingObject>();
		for (FlyingObject flo : enemies) {
			for (FlyingObject bullet : myBullets) {
				if (flo.collide(bullet)) {
					removedEnemies.add(flo);
					break;

				}
			}
		}
		enemies.removeAll(removedEnemies);
	}

	private void heroMove(int time) {
		if (time % hero.getSpeed() == 0)
			hero.move();
	}

	private void myBulletsMove(int time) {
		for (FlyingObject flo : myBullets) {
			if (time % flo.getSpeed() == 0)
				flo.move();

		}
	}

	private void enemiesShoot(int time) {
		if (time % 300 == 0) {
			for (FlyingObject enemy : enemies) {
				FlyingObject bullet = new FlyingObject();
				bullet.setX(enemy.getX());
				bullet.setY(enemy.getY() + enemy.getImage().getHeight() + 10);
				bullet.setDown(true);
				bullet.setSpeed(5);
				Random r = new Random();
				int result = r.nextInt() % 3;
				if (result == 0) {
					bullet.setLeft(false);
					bullet.setRight(false);
				} else if (result == 1) {
					bullet.setLeft(true);
					bullet.setRight(false);
				} else if (result == 2) {
					bullet.setLeft(false);
					bullet.setRight(true);
				}
				try {
					bullet.setImage(ImageIO.read(Game.class
							.getResourceAsStream("/images/bullet.png")));
				} catch (IOException e) {
					e.printStackTrace();
				}
				bullets.add(bullet);
			}
		}
	}

	private void addEnemy(int time) {
		if (time % 2000 == 0) {
			FlyingObject enemy = new FlyingObject();
			enemy.setY(0);
			enemy.setX((int) (Math.random() * 300));
			enemy.setDown(true);
			enemy.setSpeed(10);
			try {
				enemy.setImage(ImageIO.read(Game.class
						.getResourceAsStream("/images/enemy.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			enemies.add(enemy);
		}
	}

	private void bulletsMove(int time) {
		for (FlyingObject flo : bullets) {
			if (time % flo.getSpeed() == 0)
				flo.move();

		}
	}

	private void enemiesMove(int time) {
		for (FlyingObject flo : enemies) {
			if (time % flo.getSpeed() == 0)
				flo.move();
		}
	}

	public void draw(Graphics g) {
		for (FlyingObject flo : enemies) {
			flo.draw(g);
		}
		for (FlyingObject flo : bullets) {
			flo.draw(g);
		}
		for (FlyingObject flo : myBullets) {
			flo.draw(g);
		}
		hero.draw(g);
	}

	public FlyingObject getHero() {
		return hero;
	}

	public void shoot() {
		FlyingObject bullet = new FlyingObject();
		bullet.setX(hero.getX());
		bullet.setY(hero.getY() - 10);
		bullet.setUp(true);
		try {
			bullet.setImage(ImageIO.read(Game.class
					.getResourceAsStream("/images/bullet1.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		myBullets.add(bullet);

	}

}
