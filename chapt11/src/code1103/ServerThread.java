/**
 * 
 */
package code1103;
import java.io.*;
import java.net.*;

/**
 * ServerThread.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */

public class ServerThread extends Thread {
	private Socket s;
	private DataInputStream is;
	private DataOutputStream os;

	// 在构造方法中为每个套接字连接输入和输出流
	public ServerThread(Socket socket) throws IOException {
		super();
		s = socket;
		is = new DataInputStream(s.getInputStream());
		os = new DataOutputStream(s.getOutputStream());
		start(); // 启动run()方法
	}

	// 在run()方法中与客户端通信
	public void run() {
		try {
			String str;
			double result, zhi;
			boolean NotEnd = true;
			while (NotEnd) {
				str = is.readUTF();
				if (!str.equals("bye")) {
					zhi = Double.parseDouble(str);
					System.out.println("接收到的值为：" + zhi);
					result = zhi * zhi;
					str = Double.toString(result);
					os.writeUTF(str);
					os.flush();
					System.out.println("平方值" + str + "已经发送");
				} else {
					NotEnd = false;
					os.writeUTF("bye");
					os.flush();
				}
			}
			is.close();
			os.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
