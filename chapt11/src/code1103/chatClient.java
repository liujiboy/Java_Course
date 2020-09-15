/**
 * 
 */
package code1103;

/**
 * chatClient.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.net.*;
import java.io.*; 
public class chatClient { 
	public static void main(String args[]) throws Exception { 
		int c; 
		Socket s1; 
		InputStream s1In; 
		DataInputStream dis; 
		s1 = new Socket("localhost",5600); //创建客户端Socket，连接服务器
		s1In = s1.getInputStream(); 
		dis = new DataInputStream(s1In); //建立输入流
		String st = new String (dis.readUTF()); 
		System.out.println(st); 
		s1In.close(); 
		s1.close(); 
	} 
 }

