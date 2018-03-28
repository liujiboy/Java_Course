package narcissisticnumber;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Version6 {
	public static void main(String[] args) {
		IntPredicate intP=i->isNarcissisticNumber(i);
		IntConsumer intC=i->System.out.println(i);
		IntStream.range(100, 1000).filter(intP).forEach(intC);
	}

	public static boolean isNarcissisticNumber(int i) {
		int a = i / 100;
		int b = (i / 10) % 10;
		int c = i % 10;
		return a * a * a + b * b * b + c * c * c == i;
	}
}
