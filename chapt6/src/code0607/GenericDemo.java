package code0607;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
public class GenericDemo {
	public static void main(String[] args) {
		// 用泛型后，集合中存放Integer类型的元素
		ArrayList<Integer> a = new ArrayList<Integer>();
		Random r=new Random();
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			a.add(r.nextInt(1000));
		}
		// 迭代器中的元素类型是Integer
		for (Iterator<Integer> i = a.iterator(); i.hasNext();) {
			sum =sum+i.next();
		}
		System.out.println(sum);
	}
}
