package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Version1 {
	public static void main(String args[])
	{
		List<Integer> list=Arrays.asList(2,3,1,7,5);
		list.sort(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		for(Integer i:list)
		{
			System.out.println(i);
		}
	}
}
