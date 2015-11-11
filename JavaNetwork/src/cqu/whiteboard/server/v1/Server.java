package cqu.whiteboard.server.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static byte[] datas;
	private static Object lock = new Object();
	public static void main(String[] args) {
		ServerSocket s = null;
		try {
			s = new ServerSocket(8000);
			while (true) {
				final Socket socket = s.accept();
				System.out.printf("%s已经连接\n", socket.getInetAddress()
						.toString());
				// 每个客户端连接创建一个线程进行处理
				Thread serverThread = new Thread() {
					public void run() {
						try {
							DataInputStream in = new DataInputStream(
									socket.getInputStream());
							DataOutputStream out = new DataOutputStream(
									socket.getOutputStream());
							// 先读取客户端的类型，0表示PaintFrame，1表示ViewerFrame
							int type = in.readInt();
							while (true) {
								if (type == 0) {
									// PaintFrame
									//接收数据
									int totalSize = in.readInt();
									byte newdatas[] = new byte[totalSize];
									int receivedSize=in.read(newdatas);
									while(receivedSize<totalSize)
									{
										receivedSize+=in.read(newdatas,receivedSize,totalSize-receivedSize);
									}
									synchronized (lock) {
										datas = newdatas;
									}
								} else {
									// ViewerFrame
									//发送数据
									synchronized (lock) {
										out.writeInt(datas.length);
										out.write(datas);
										out.flush();
									}
									Thread.sleep(50);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				};
				serverThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
