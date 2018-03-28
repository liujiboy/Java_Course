package timing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		
		Timer.timeit(new Timeable(){

			@Override
			public void func() {
				f();
				
			}
			
		});
		
	}
	public static void f()
	{
		List<Integer> list = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 100000; i++)
			list.add(r.nextInt());
	}

}
