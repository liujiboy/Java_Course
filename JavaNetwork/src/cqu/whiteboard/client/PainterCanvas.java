package cqu.whiteboard.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JPanel;

import cqu.whiteboard.model.ImageUtils;

public class PainterCanvas extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7564327781790208553L;
	private BufferedImage image;
	private Object lock=new Object();
	private boolean update=false;
	public PainterCanvas() {

		this.addMouseMotionListener(new MouseMotionAdapter() {
			private int startX = 0;
			private int startY = 0;
			private boolean first = true;

			@Override
			public void mouseMoved(MouseEvent e) {
				if (image != null) {
					if (first) {
						first = false;
						startX = e.getX();
						startY = e.getY();
					} else {
						Graphics g = image.getGraphics();
						g.setColor(Color.RED);
						g.drawLine(startX, startY, e.getX(), e.getY());
						PainterCanvas.this.repaint(); // 匿名类访问外部this的小技巧
						startX = e.getX();
						startY = e.getY();
						//仅当鼠标移动后才发送数据
						synchronized(lock){
							update=true;
						}
					}
				}
			}

		});
		Thread clientThread = new Thread(this);
		clientThread.start();
	}

	public void run() {
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 8000);
			DataOutputStream out = new DataOutputStream(
					socket.getOutputStream());
			out.writeInt(0);
			while (true) {
				if (image != null&&update) {
					//发送数据
					byte datas[] = ImageUtils.image2bytes(image);
					out.writeInt(datas.length);
					out.write(datas);
					out.flush();
					synchronized(lock){
						update=false;
					}
				}
				Thread.sleep(50);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void paint(Graphics g) {
		if (image == null) {
			image = new BufferedImage(this.getWidth(), this.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			Graphics ig=image.getGraphics();
			ig.setColor(Color.WHITE);
			ig.fillRect(0, 0, image.getWidth(), image.getHeight());
		}
		g.drawImage(image, 0, 0, null);
	}

}
