package narcissisticnumber;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Version5 {
	public static void main(String[] args) {
		IntPredicate intP=new IntPredicate() {
			@Override
			public boolean test(int i) {
				return isNarcissisticNumber(i);
			}
		};
		IntConsumer intC=new IntConsumer() {

			@Override
			public void accept(int i) {
				System.out.println(i);
			}
		};
		IntStream.range(100, 1000).filter(intP).forEach(intC);
	}

	public static boolean isNarcissisticNumber(int i) {
		int a = i / 100;
		int b = (i / 10) % 10;
		int c = i % 10;
		return a * a * a + b * b * b + c * c * c == i;
	}
}
