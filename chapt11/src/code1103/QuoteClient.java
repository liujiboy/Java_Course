/**
 * 
 */
package code1103;

/**
 * QuoteClient.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class QuoteClient {

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Usage:java QuoteClient <hostname>");
			return;
		}
		DatagramSocket socket = new DatagramSocket();// 创建数据报Socket
		// 发送请求
		byte[] buf = new byte[256];
		InetAddress address = InetAddress.getByName(args[0]); // 获取目标地址
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
		// 创建发送数据报
		socket.send(packet); // 发送
		// 获取响应
		packet = new DatagramPacket(buf, buf.length); // 创建接受数据报
		socket.receive(packet); // 接受数据报
		// 显示响应
		String received = new String(packet.getData());
		System.out.println("Quote of the Moment:" + received);
		socket.close(); // 关闭Socket
	}
}
