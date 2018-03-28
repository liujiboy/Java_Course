package timing;

public class Timer {
	public static void timeit(Timeable t)
	{
		long start=System.nanoTime();
		t.func();
		long end=System.nanoTime();
		System.out.println((end-start)/1000000+"ms");
	}
}
