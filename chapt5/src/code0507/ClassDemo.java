/**
 * 
 */
package code0507;

import java.lang.reflect.*;

/**
 * ClassDemo.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class ClassDemo {
	public static void main(String args[]) {
		try {
			Class cls = Class.forName("code0507.Person");
			Constructor ct = cls.getConstructor(int.class);
			Object obj = ct.newInstance(20);
			// 获取类中的所有方法及其属性
			Method[] methods = cls.getDeclaredMethods();
			for (Method m : methods) {
				System.out.print(Modifier.toString(m.getModifiers()) + " " + m.getReturnType().getName() + " "
						+ m.getName() + "(");
				Class<?>[] paras = m.getParameterTypes();
				for (Class<?> p : paras) {
					System.out.print(p.getName() + " ");
				}
				System.out.println(")");
			}
			
			Method meth = cls.getMethod("addAge", int.class);
			// 调用指定的方法
			Object retObject = meth.invoke(obj, 5);
			System.out.println("After addAge():" + retObject);
			
			// 获取类中所有的属性
			Field[] field = cls.getDeclaredFields();
			for (Field f : field) {
				// 属性修饰符
				System.out.print(Modifier.toString(f.getModifiers()) + " ");
				// 属性类型
				System.out.print(f.getType().getName() + " ");
				// 属性名称
				System.out.println(f.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
