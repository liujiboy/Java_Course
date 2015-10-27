package edu.cqu;

import java.io.UnsupportedEncodingException;

public class UTF8ToISOToUTF8 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String utf8String="UT8转为GBKيتفقان على التنسيق عسكريا ";
		System.out.println(utf8String);
		byte[] utf8bytes=utf8String.getBytes("UTF-8");
		//被错误转为ISO-8859-1（例如在网络传输过程中）
		String isoString=new String(utf8bytes,"ISO-8859-1");
		//直接使用isoString会导致乱码，需要将isoString转换为UTF-8
		System.out.println(isoString);
		//正确的转换
		utf8bytes=isoString.getBytes("ISO-8859-1");
		String newUTF8String=new String(utf8bytes,"UTF-8");
		System.out.println(newUTF8String);
	}
}
