/**
 * 
 */
package code0602;

 /**
 * SplitString.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class SplitString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//构造包含逗号、句号的正则表达式
		String regex="[，。]+"; 
		//被分割的字符串
		String s="中国，你好。Java。。程序设计。";
		//使用逗号、句号分割字符串
		String[] ss=s.split(regex);
		for(String a:ss)
		{
			System.out.println(a);
		}
	}
}
