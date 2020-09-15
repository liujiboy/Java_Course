/**
 * 
 */
package code0602;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CheckIPAddress.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
public class CheckIPAddress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		// 构造匹配IP地址的模式
		p = Pattern.compile("[1-2]\\d{0,2}+\\.[1-2]\\d{0,2}+\\.[1-2]\\d{0,2}+\\.[1-2]\\d{0,2}");
		String[] ips = { "192.168.1.1", "192.168.1.1345", "222.168.1.134", "322.168.1.134" };

		for (String s : ips) {
			m = p.matcher(s);
			b = m.matches();
			System.out.println("IP正确：" + b);
		}

	}

}
