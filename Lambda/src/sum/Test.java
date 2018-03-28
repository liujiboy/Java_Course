package sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import timing.Timer;

public class Test {

	public static void main(String[] args) {
		List<Long> list = new ArrayList<>();
		for (Long i = 1l; i < 10000000; i++) {
			list.add(i);
		}
		Timer.timeit(() -> {
			Optional<Long> sum = list.stream().filter(i -> i % 2 == 0).reduce((a, b) -> a + b);
			sum.ifPresent(System.out::println);
		});
		Timer.timeit(() -> {
			Optional<Long> sum = list.parallelStream().filter(i -> i % 2 == 0).reduce((a, b) -> a + b);
			sum.ifPresent(System.out::println);
		});
	}

}
