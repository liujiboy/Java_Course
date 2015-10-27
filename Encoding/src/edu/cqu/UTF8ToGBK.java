package edu.cqu;

import java.io.UnsupportedEncodingException;
/**
 * 文件编码为UTF-8
 * @author liuji
 *
 */
public class UTF8ToGBK {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String utf8String="UT8转为GBKيتفقان على التنسيق عسكريا ";
		//转换为GBK
		byte[] gbkBytes=utf8String.getBytes("GBK");
		String gbkString=new String(gbkBytes,"GBK");
		System.out.println(utf8String);
		System.out.println(gbkString);
	}

}
