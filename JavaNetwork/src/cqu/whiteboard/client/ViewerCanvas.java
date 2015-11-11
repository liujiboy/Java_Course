package cqu.whiteboard.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JPanel;

import cqu.whiteboard.model.ImageUtils;

public class ViewerCanvas extends JPanel implements Runnable {
	private static final long serialVersionUID = 4733310082522388698L;
	private BufferedImage image;

	public ViewerCanvas() {
		Thread clientThread = new Thread(this);
		clientThread.start();
	}
	public void run() {
		Socket socket=null;
		try {
			socket = new Socket("127.0.0.1", 8000);
			DataOutputStream out = new DataOutputStream(
					socket.getOutputStream());
			out.writeInt(1);
			while (true) {

				DataInputStream in = new DataInputStream(
						socket.getInputStream());
				//接收数据
				int totalSize = in.readInt();
				byte newdatas[] = new byte[totalSize];
				int receivedSize=in.read(newdatas);
				while(receivedSize<totalSize)
				{
					receivedSize+=in.read(newdatas,receivedSize,totalSize-receivedSize);
				}
				//重绘
				image = ImageUtils.bytes2Image(newdatas);
				ViewerCanvas.this.repaint();
				Thread.sleep(50);

			}

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}finally{
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
