/**
 * 
 */
package code0602;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JudgeMobileNumber.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
public class JudgeMobileNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		// 正则表达式表示第一位是1，第二位为3,4,5，结尾为9位数字的一串数字
		p = Pattern.compile("^[1][3-5]+\\d{9}");
		String[] numbers = { "13996332243", "1227788", "15676789065", "139abcd1234" };
		for (String s : numbers) {
			m = p.matcher(s);
			b = m.matches();
			System.out.println("手机号码正确：" + b);
		}
	}
}
