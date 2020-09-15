/**
 * 
 */
package code1102;

/**
 * GetIP.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.net.*;
public class GetIP {
	public static void main(String[] args) {
		try{
			System.out.println("本机IP为："+InetAddress.getByName(args[0]));
		}catch(UnknownHostException el){
			el.printStackTrace();
		}
	}
}
