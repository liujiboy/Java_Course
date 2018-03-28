package lambda;

import java.util.Arrays;
import java.util.List;

public class Version7 {
	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(2, 3, 1, 7, 5);
		list.sort(Integer::compare);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
