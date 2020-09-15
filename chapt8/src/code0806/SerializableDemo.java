package code0806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	int age;
	String department;

	public Student(int id, String name, int age, String department) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
	}
}

public class SerializableDemo {
	public static void main(String args[]) throws Exception {
		Student stu = new Student(20151064, "zhang shan", 22, "CQUCS");
		FileOutputStream fout = new FileOutputStream("data1.ser");
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		// 输出对象
		oout.writeObject(stu);
		oout.close();
		stu = null;
		FileInputStream fin = new FileInputStream("data1.ser");
		ObjectInputStream oin = new ObjectInputStream(fin);
		// 读入对象
		stu = (Student) oin.readObject();
		oin.close();
		System.out.println("学生信息：");
		System.out.println("ID：        " + stu.id);
		System.out.println("name：      " + stu.name);
		System.out.println("age：       " + stu.age);
		System.out.println("department：" + stu.department);
	}
}
