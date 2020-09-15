package code0607;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
public class HashMapDemo
{
	public static void main(String[] args)
	{
		HashMap hm = new HashMap();
		Random r=new Random();
		// 把元素加入映射
		hm.put("John", r.nextInt(10000));
		hm.put("Tom", r.nextInt(10000));
		hm.put("Jane", r.nextInt(10000));
		hm.put("Hall",r.nextInt(10000));
		hm.put("Smith", r.nextInt(10000));
		// 得到映射项的集合
		Set set = hm.entrySet();
		Iterator i =set.iterator();
		// 显示元素
		while (i.hasNext())
		{
			Map.Entry me =(Map.Entry)i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		// 存100元到John的帐户
		int balance = ((Integer)hm.get("John")).intValue();
		hm.put("John", new Integer((int) (balance + 100)));
		System.out.println("John's new balance: " + hm.get("John"));
	}
}
