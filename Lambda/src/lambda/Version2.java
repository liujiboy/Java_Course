package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Version2 {
	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(2, 3, 1, 7, 5);
		Comparator<Integer> intC = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		list.sort(intC);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
