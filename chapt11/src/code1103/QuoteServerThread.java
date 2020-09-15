/**
 * 
 */
package code1103;

/**
 * QuoteServerThread.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class QuoteServerThread extends Thread {
	protected DatagramSocket socket = null;
	protected BufferedReader in = null;
	protected boolean moreQuotes = true;

	public QuoteServerThread() throws IOException {
		this("QuoteServerThread");
	}

	public QuoteServerThread(String name) throws IOException {
		super(name);
		socket = new DatagramSocket(4445); // 创建数据报Socket。
		try {
			in = new BufferedReader(new FileReader("one.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Could not open quote file. Serving time instead.");
		}
	}

	public void run() {
		while (moreQuotes) {
			try {
				byte[] buf = new byte[256];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				// 生成数据报，准备接受。
				socket.receive(packet); // 接受
				String dString = null;
				if (in == null)
					dString = new Date().toString();
				else
					dString = getNextQuotes();
				buf = dString.getBytes();
				// 发送响应给客户端，使用收到的数据包的“address”和“port”。
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				packet = new DatagramPacket(buf, buf.length, address, port); // 创建发送数据报
				socket.send(packet); // 发送
			} catch (IOException e) {
				e.printStackTrace();
				moreQuotes = false;
			}
		}
		socket.close();
	}

	// 获取下一个需要发送的数据内容。
	protected String getNextQuotes() {
		String returnValue = null;
		try {
			if ((returnValue = in.readLine()) == null) {
				in.close();
				moreQuotes = false;
				returnValue = "No more quotes.Goodbye.";
			}
		} catch (IOException e) {
			returnValue = "IOException occurred in server";
		}
		return returnValue;
	}
}
