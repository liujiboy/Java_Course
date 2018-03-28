package narcissisticnumber;

import java.util.stream.IntStream;

public class Version2 {
	public static void main(String args[]) {
		IntStream.range(100, 1000).filter(Version2::isNarcissisticNumber)
		.forEach(System.out::println);
	}

	public static boolean isNarcissisticNumber(int i) {
		int a = i / 100;
		int b = (i / 10) % 10;
		int c = i % 10;
		return a * a * a + b * b * b + c * c * c == i;
	}
}
