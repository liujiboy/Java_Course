package edu.cqu.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test3 {

	public static void main(String[] args) {
		Student s1 = new Student("s1", 10);
		Student s2 = new Student("s2", 20);
		Student s3 = new Student("s3", 100);
		Student s4 = new Student("s4", 200);
		Map<String, Student> map = new TreeMap<String, Student>((o1, o2) -> -1 * o1.compareTo(o2));
		map.put(s1.getId(), s1);
		map.put(s3.getId(), s3);
		map.put(s2.getId(), s2);
		map.put(s4.getId(), s4);
		for (Object key : map.keySet()) {
			System.out.println(map.get(key));
		}
	}

}
