package cn.edu.cqu.cglib;

public class CglibDemo {

	public static void main(String[] args) {
		
        Person p=(Person)PersonProxy.create("foo", 10);
        System.out.println(p.getClass());
        System.out.println(p.getName());
        System.out.println(p.getAge());

	}

}
