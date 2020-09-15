package code0607;

import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		// 创建一个List
		ArrayList al = new ArrayList();
		System.out.println("List的初始大小: " + al.size());
		// 向List中增加元素
		al.add("A");
		al.add("B");
		al.add("C");
		al.add("D");
		al.add("E");
		al.add("F");
		al.add(1, "A2");
		System.out.println("增加元数后的大小: " + al.size());
		// 显示其内容
		System.out.println("List中的内容: " + al);
		// 删除List中的元素
		al.remove("D");
		al.remove(2);
		System.out.println("删除元素后的大小：" + al.size());
		System.out.println("内容: " + al);
		//转化为数组
		Object[] aa=al.toArray();
		for(Object a :aa)
		{
			System.out.print(a);
		}
	}
}
