/**
 * 
 */
package code0507;
import java.lang.reflect.*;
/**
 * CallTest.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class CallTest {
	public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("code0507.Person");
      
            //调用Person类中的sayChina方法
            Method method=demo.getMethod("sayChina");
            method.invoke(demo.newInstance());
            //调用Person的sayHello方法
            method=demo.getMethod("sayHello", String.class,int.class);
            method.invoke(demo.newInstance(),"Rollen",20);
            Object obj = demo.newInstance();
            Field field = demo.getDeclaredField("sex");
            field.setAccessible(true);
            field.set(obj, "男");
            System.out.println(field.get(obj));
             
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
