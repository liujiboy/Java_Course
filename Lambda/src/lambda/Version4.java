package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Version4 {
	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(2, 3, 1, 7, 5);
		Comparator<Integer> intC = ( o1,  o2) -> {
			return o1.compareTo(o2);
		};
		list.sort(intC);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
