/**
 * 
 */
package code1103;

/**
 * Client.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) {
		try {
			// 连接到本机，端口号5500
			Socket s = new Socket("localhost", 5500);
			// 将数据输入流连接到socket上
			DataInputStream is = new DataInputStream(s.getInputStream());
			// 将数据输出流连接到socket上
			DataOutputStream os = new DataOutputStream(s.getOutputStream());
			System.out.println("输入待求平方值，输入bye结束。");
			String outStr, inStr;
			boolean NotEnd = true;
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			// 反复读用户的数据并计算
			while (NotEnd) {
				outStr = buf.readLine(); // 读入用户的输入
				os.writeUTF(outStr); // 写到socket中
				os.flush(); // 清空缓冲区，立即发送
				inStr = is.readUTF(); // 从socket中读数据
				if (!inStr.equals("bye"))
					System.out.println("返回结果：" + inStr);
				else
					NotEnd = false;
			}
			is.close();
			os.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
