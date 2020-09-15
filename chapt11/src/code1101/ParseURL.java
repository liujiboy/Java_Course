/**
 * 
 */
package code1101;

/**
 * ParseURL.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.net.*;
public class ParseURL {
	public static void main(String[] args) throws Exception {
		URL cqu = new URL("http://www.cqu.edu.cn/index.html#top");
		System.out.println("protocol=" + cqu.getProtocol()); // 协议
		System.out.println("host=" + cqu.getHost()); // 主机名
		System.out.println("filename=" + cqu.getFile());// 文件名
		System.out.println("port=" + cqu.getPort()); // 端口
		System.out.println("ref=" + cqu.getRef());// 文件内部的一个引用
	}
}
