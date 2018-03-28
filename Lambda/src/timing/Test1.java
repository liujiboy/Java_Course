package timing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test1 {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		Timer.timeit(()->{
			Random r=new Random();
			for(int i=0;i<100000;i++)
				list.add(r.nextInt());
		});
		Timer.timeit(()->{
			list.sort(Integer::compareTo);
		});
	}

}
