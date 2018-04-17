package edu.cqu.ioc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.cqu.ioc.annotation.Bean;
import edu.cqu.ioc.annotation.Component;
import edu.cqu.ioc.annotation.ComponentScan;
import edu.cqu.ioc.annotation.Configuration;
import edu.cqu.ioc.utils.ClassTool;

public class ApplicationContext {
	private Map<Class<?>, Object> map = new HashMap<>();

	public ApplicationContext(Class<?>... clzs){
		try {
			for (Class<?> clz : clzs) {
				loadBeans(clz);
				scanComponents(clz);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void scanComponents(Class<?> clz) {
		ComponentScan cs=clz.getAnnotation(ComponentScan.class);
		if(cs!=null)
		{
			String[] packages=cs.value();
			if(packages.length==0)
				packages=new String[] {clz.getPackage().getName()};
			for(String pk:packages)
			{
				Set<Class<?>> clzSet=ClassTool.getClasses(pk);
				for(Class<?> c:clzSet)
				{
					Component com=c.getAnnotation(Component.class);
					if(com!=null)
					{
						loadComponent(c);
					}
				}
			}
		}
	}

	private void loadComponent(Class<?> c) {
		try {
			Object o=c.newInstance();
			Field[] fields=c.getDeclaredFields();
			for(Field f:fields)
			{
				Autowired aw=f.getAnnotation(Autowired.class);
				if(aw!=null)
				{
					f.setAccessible(true);
					f.set(o, map.get(f.getType()));
				}
			}
			map.put(c, o);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	private void loadBeans(Class<?> clz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		Configuration conf = clz.getAnnotation(Configuration.class);
		if (conf != null) {
			Object confObj = clz.newInstance();
			Method[] methods = clz.getDeclaredMethods();
			for (Method m : methods) {
				Bean bean = m.getAnnotation(Bean.class);
				if (bean != null) {
					Object ret = m.invoke(confObj);
					map.put(m.getReturnType(), ret);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getBean(Class<T> clz) {
		return (T) map.get(clz);
	}
}
