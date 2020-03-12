package database;

import java.util.HashSet;
import java.util.Set;

import domains.User;

public class DB {
	private static Set<User> users=new HashSet<User>();
	static {
		addUser("app2u1","001","App2_张三","xxx",10);
		addUser("app2u2","001","App2_李四","xxx",10);
	}
	
	public static void addUser(String id,String pwd,String name,String email,int age)
	{
		User u=new User();
		u.setAge(age);
		u.setEmail(email);
		u.setId(id);
		u.setName(name);
		u.setPwd(pwd);
		users.add(u);
	}

	public static User getUser(String userId) {
		for(User u:users)
		{
			if(u.getId().equals(userId))
				return u;
		}
		return null;
	}
}
