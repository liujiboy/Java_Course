package edu.cqu.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {

	public static void main(String[] args) {
		Student s1=new Student("s1",10);
		Student s2=new Student("s2",20);
		Student s3=new Student("s3",5);
		Comparator<Student> c=new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getAge().compareTo(o2.getAge());
			}
			
		};
		Set<Student> set=new TreeSet<Student>(c);
		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.println(set);
	}

}
