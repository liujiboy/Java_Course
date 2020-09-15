package code0607;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
public class TreeMapDemo
{
	public static void main(String[] args)
	{
		TreeMap  tm = new TreeMap();
		Random r=new Random();
		int f=10000;
		// 放入元素
		tm.put("E", f*r.nextDouble());
		tm.put("A", f*r.nextDouble());
		tm.put("B", f*r.nextDouble());
		tm.put("C", f*r.nextDouble());
		tm.put("F", f*r.nextDouble());
		tm.put("D", f*r.nextDouble());
		// 得到关键字列表
		Set set = tm.keySet();
		// 得到迭代器
		Iterator i = set.iterator();
		// 通过迭代器显示TreeMap中的值
		while (i.hasNext())
		{
			String key = (String)i.next();
			System.out.println(key + ": " + ((Double)tm.get(key)).doubleValue());
		}
		// 存 1000 到D's 帐户
		double balance = ((Double)tm.get("D")).doubleValue();
		tm.put("D", new Double(balance + 1000));
		System.out.println("D's new balance: " + tm.get("D"));
	}
}
