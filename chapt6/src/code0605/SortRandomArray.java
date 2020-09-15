/**
 * 
 */
package code0605;

import java.util.Arrays;
import java.util.Random;

/**
 * SortRandomArray.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class SortRandomArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] cc=new char[20];
		Random r=new Random();
		
		for(int i=0;i<cc.length;i++)
		{
			cc[i]=(char) ('A'+r.nextInt(26));
		}
		//ÅÅÐòÇ°
        System.out.println(new String(cc));
        //ÅÅÐò
        Arrays.sort(cc);
        System.out.println(new String(cc));
		
	}

}
