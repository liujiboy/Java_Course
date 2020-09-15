/**
 * 
 */
package code0507;

import java.util.*;
import java.lang.reflect.Method;

/**
 * UserAnnotation.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
public class UserAnnotation {
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();
		Collections.addAll(li, 47, 48, 49, 50);// 将元素47,48,49,50插入到集合li中
		trackUseCases(li, PasswordUtils.class);
	}

	public static void trackUseCases(List<Integer> li, Class<?> cl) {
		for (Method m : cl.getDeclaredMethods()) {
			UseCase uc = m.getAnnotation(UseCase.class);
			if (uc != null) {
				System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
				li.remove(new Integer(uc.id()));
			}
		}
		for (int i : li) {
			System.out.println("Warning: Missing use case-" + i);
		}
	}
}
