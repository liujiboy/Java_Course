package cn.edu.cqu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

	public static void main(String[] args) {
		try {
			//动态加载class
			Class<?> clz=Class.forName("cn.edu.cqu.reflection.Person"); 
			//获取构造函数
			Constructor<?> con=clz.getConstructor(String.class,int.class);
			//调用构造函数
			Object obj=con.newInstance("foo",10);
			//使用对象
			System.out.println(obj.getClass());
			Person p=(Person)obj;
			System.out.println(p.getName());
			System.out.println(p.getAge());
			//获取属性
			System.out.println("public属性包括：");
			for(Field f:clz.getFields())
			{
				System.out.println(f.getName());
			}
			//获取方法
			System.out.println("方法包括：");
			for(Method m:clz.getMethods())
			{
				System.out.println(m.getName());
			}
			//调用方法
			Method getName=clz.getMethod("getName");
			Method setName=clz.getMethod("setName",String.class);
			System.out.printf("调用Person的getName方法，结果为：%s\n",getName.invoke(obj));
			setName.invoke(obj, "bar");
			System.out.printf("调用setName之后，再Person的getName方法，结果为：%s\n",getName.invoke(obj));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
