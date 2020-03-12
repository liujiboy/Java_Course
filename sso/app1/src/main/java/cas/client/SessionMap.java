package cas.client;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class SessionMap {
	private static Map<String,HttpSession> map=new HashMap<String,HttpSession>();
	public static void put(HttpSession session)
	{
		map.put(session.getId(), session);
	}
//	public static HttpSession get(String id)
//	{
//		return map.get(id);
//	}
//	public static void remove(String id)
//	{
//		map.remove(id);
//	}
	public static void invalidate(String id)
	{
		HttpSession session=map.get(id);
		session.invalidate();
		map.remove(id);
	}
}
