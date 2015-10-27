package edu.cqu;

import java.io.UnsupportedEncodingException;
/**
 * 文件编码为GBK
 */
public class GBKToUTF8 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String gbkString="GBK转为UTF-8";
		//转为UTF-8
		byte[] utf8bytes=gbkString.getBytes("UTF-8");
		String utf8String=new String(utf8bytes,"UTF-8");
		System.out.println(gbkString);
		System.out.println(utf8String);
	}

}
