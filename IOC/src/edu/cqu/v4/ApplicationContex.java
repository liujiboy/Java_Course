package edu.cqu.v4;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import edu.cqu.v4.annotation.Autowired;
import edu.cqu.v4.annotation.Component;

public class ApplicationContex {
	private Map<String, Object> map = new HashMap<>();

	public ApplicationContex() {
		addAnnotatedClass(Camera.class);
		addAnnotatedClass(Disk.class);
		addAnnotatedClass(MP3.class);
		addAnnotatedClass(Scanner.class);
		addAnnotatedClass(Computer.class);
	}
	public void addAnnotatedClass(Class<?> clz)
	{
		Component component=clz.getAnnotation(Component.class);
		try {
			Object obj=clz.newInstance();
			map.put(component.name(), obj);
			Field[] fields=clz.getDeclaredFields();
			for(Field f:fields)
			{
				Autowired autowired=f.getAnnotation(Autowired.class);
				if(autowired!=null)
				{
					f.setAccessible(true);
					f.set(obj, map.get(autowired.name()));
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	public Object getBean(String beanName) {
		return map.get(beanName);
	}


}
