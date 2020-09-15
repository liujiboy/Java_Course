/**
 * 
 */
package code0304;

/**
 * SortByChinese.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

public class SortByChinese {
	public static void main(String[] args) {
		String[] arrStrings = {"计算机","长江", "通讯","数学"};
		Arrays.sort(arrStrings);
		for (int i = 0; i < arrStrings.length; i++)
			System.out.println(arrStrings[i]);
		System.out.println("----------------------------");

		// Collator 类是用来执行区分语言环境的 String 比较的，这里选择使用CHINA
		Comparator comparator = Collator.getInstance(java.util.Locale.CHINA);
		// 使根据指定比较器产生的顺序对指定对象数组进行排序。
		Arrays.sort(arrStrings, comparator);
		for (int i = 0; i < arrStrings.length; i++) System.out.println(arrStrings[i]); }
}
