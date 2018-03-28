package edu.cqu.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test1 {

	public static void main(String[] args) {
		Student s1=new Student("s1",10);
		Student s2=new Student("s1",10);
		List<Student> list=new ArrayList<Student>();
		Set<Student> set=new HashSet<Student>();
		list.add(s1);
		list.add(s2);
		set.add(s1);
		set.add(s2);
		System.out.println(list);
		System.out.println(list);
	}

}
