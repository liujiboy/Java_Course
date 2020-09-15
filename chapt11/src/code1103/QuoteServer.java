/**
 * 
 */
package code1103;

/**
 * QuoteServer.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class QuoteServer {
	public static void main(String args[]) throws java.io.IOException {
		new QuoteServerThread().start(); // 启动，创建服务器线程。
	}
}