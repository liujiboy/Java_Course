package cn.edu.cqu.annotation;

public class AnnotationDemo {

	public static void main(String[] args) {
		Person p=(Person)PersonProxy.create("foo", 10);
        System.out.println(p.getName());
        System.out.println(p.getAge());
        p.sayHello("bar");
	}

}
