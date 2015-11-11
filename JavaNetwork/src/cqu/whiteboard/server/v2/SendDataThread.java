package cqu.whiteboard.server.v2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SendDataThread extends Thread {
	private List<Socket> clients = new ArrayList<Socket>();
	private boolean update = false;
	private byte[] datas;
	private Object lock = new Object();//对象锁

	public void setDatas(byte[] datas) {
		//update设置为true，则在线程的run方法会更新全部客户端的数据
		synchronized (lock) {
			this.datas = datas;
			this.update = true;
		}
	}

	public void addClient(Socket s) {
		clients.add(s);
	}

	public void run() {
		while (true) {
			synchronized (lock) {
				if (update) {
					//为了提高发送效率，每个客户端创建一个发送数据的线程
					List<Thread> threads = new ArrayList<Thread>();
					for (final Socket s : clients) {
						Thread t = new Thread() {
							public void run() {
								try {
									//发送数据
									DataOutputStream out = new DataOutputStream(
											s.getOutputStream());
									out.writeInt(datas.length);
									out.write(datas);
									out.flush();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						};
						threads.add(t);
					}
					//启动发送数据线程
					for (Thread t : threads)
						t.start();
					//等待所有发送数据线程结束
					for (Thread t : threads)
						try {
							t.join();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					//设置update
					update = false;
				}

			}
		}
	}
}
