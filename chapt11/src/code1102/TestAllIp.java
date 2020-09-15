/**
 * 
 */
package code1102;

/**
 * TestAllIP.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.net.InetAddress; 
public class TestAllIp {
	public static void main(String[] args) {
		String ip = "172.20.52.";
		for (int i = 1; i < 255; i++) {
			String host = ip + i;
			new ThreadIP(host).start();
		}
	}
	static class ThreadIP extends Thread {
		String ip = null;
		public ThreadIP(String ip) {
			super();
			this.ip = ip;
		}
		@Override
		public void run() {
			super.run();
			try {
				InetAddress ia = InetAddress.getByName(ip);
				boolean bool = ia.isReachable(1500);//判断IP是否正在被使用
				if (bool) {
					System.out.println("主机: " + ip + " 可用");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
}
