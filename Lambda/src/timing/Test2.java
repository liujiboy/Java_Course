package timing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test2 {
	private static List<Integer> list=new ArrayList<>();
	public static void main(String[] args) {
		
		Timer.timeit(Test2::init);
		Timer.timeit(Test2::sort);
	}
	public static void init()
	{
		Random r=new Random();
		for(int i=0;i<100000;i++)
			list.add(r.nextInt());
	}
	public static void sort()
	{
		list.sort(Integer::compareTo);
	}
}
