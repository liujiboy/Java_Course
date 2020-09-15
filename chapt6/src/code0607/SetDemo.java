/**
 * 
 */
package code0607;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 * SetDemo.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class SetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		HashSet hs = new HashSet();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			char c = (char) ('A' + r.nextInt(25));
			ts.add(c);
			hs.add(c);
		}
		System.out.println("HashSet:" + hs);
		System.out.println("TreeSet:" + ts);

		// 操作TreeSet
		System.out.println(ts);
		System.out.println(ts.lower('T'));
		System.out.println(ts.pollFirst());
		System.out.println(ts.pollLast());
		System.out.println("TreeSet:" + ts);
		// 操作HashSet,保留和ts相同的元素
		hs.retainAll(ts);
		System.out.println("HashSet:" + hs);

	}

}
