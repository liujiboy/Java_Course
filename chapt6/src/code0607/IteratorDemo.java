package code0607;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
public class IteratorDemo
{
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			char c = (char) ('A' + r.nextInt(25));
			al.add(c);
		}
		System.out.print("原列表内容: ");
		Iterator itr = al.iterator();
		while (itr.hasNext())
		{
			Object element = itr.next();
			System.out.print(element + " ");
		}
		System.out.println();
		ListIterator litr = al.listIterator();
		while (litr.hasNext())
		{
			Object element = litr.next();
			//把当前元素设置为小写
			litr.set(element.toString().toLowerCase());
		}
		System.out.print("修改后前向遍历列表: ");
		itr = al.iterator();
		while (itr.hasNext())
		{
			Object element = itr.next();
			System.out.print(element + " ");
		}
		System.out.println();
		System.out.print("修改后后向遍历列表: ");
		while (litr.hasPrevious())
		{
			Object element = litr.previous();
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
