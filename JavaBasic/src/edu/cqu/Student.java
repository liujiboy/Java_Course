package edu.cqu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 自定义的类应该实行equals、hashCode和toString函数。
 * 利用Eclipse的功能可以很方便的生成equals和hashCode。
 * @author liuji
 *
 */
public class Student {
	private String name;
	private String id;
	

	public Student(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("id=");
		buffer.append(id);
		buffer.append("\n");
		buffer.append("name=");
		buffer.append(name);
		buffer.append("\n");
		return buffer.toString();
	}

	public static void main(String args[])
	{
		Student s1=new Student("B","1");
		Student s2=new Student("A","1");
		List<Student> l=new ArrayList<Student>();
		l.add(s1);
		l.add(s2);
		System.out.println(l);
		Set<Student> s=new HashSet<Student>();
		s.add(s1);
		s.add(s2);
		System.out.println(s);
	}
}
