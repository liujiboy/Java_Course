/**
 * 
 */
package code0603;

/**
 * Convert.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class Convert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "123456";
		String s2 = "56789";
		String s = null;
		int i1 = 0, i2 = 0, sum = 0;
		// 把字符串转换成整数
		i1 = Integer.parseInt(s1);
		i2=new Integer(s2).intValue();
		sum=i1+i2;
		System.out.println("和："+sum);
		//转换成二进制字符串形式
		String s3=Integer.toBinaryString(sum);
		System.out.println("二进制："+s3);
		//转换成16进制形式
		String s4=Integer.toHexString(sum);
		System.out.println("16进制："+s4);
		

	}

}
