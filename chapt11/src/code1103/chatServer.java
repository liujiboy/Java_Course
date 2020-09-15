/**
 * 
 */
package code1103;

/**
 * chatServer.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.net.*;
import java.io.*;

public class chatServer {
	public static void main(String args[]) {
		ServerSocket s = null;
		Socket s1;
		String sendString = "Hello Net World!";
		OutputStream s1out;
		DataOutputStream dos;
		try {
			s = new ServerSocket(5600); // 使用本地5600端口提供服务
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				s1 = s.accept(); // 等待客户端的连接,如果连接成功返回Socket对象
				s1out = s1.getOutputStream();
				dos = new DataOutputStream(s1out); // 建立输出流
				dos.writeUTF(sendString);
				s1out.close();
				s1.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
