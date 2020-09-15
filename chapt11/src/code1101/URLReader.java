/**
 * 
 */
package code1101;

import java.util.*;
/**
 * URLReader.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.net.*;
import java.io.*;

public class URLReader {
	public static void main(String[] args) throws Exception {
		try {
			// 通过URL类建立远程连接，并获取连接内容
			URL obj = new URL("http://www.cqu.edu.cn/");
			BufferedReader in = new BufferedReader(new InputStreamReader(obj.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();

			// 通过URLConnection获取Http响应Header信息
			URLConnection conn = obj.openConnection();
			conn.connect();
			System.out.println("获取到的响应长度");
			System.out.println(conn.getContentLength());
			System.out.println("获取到的响应类型 ");
			System.out.println(conn.getContentType());
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			String result = null;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
