package cqu;

public class SumTest {

	public static void main(String[] args) {
		SumThread threads[]=new SumThread[10];
		long start=System.nanoTime();
		for(int i=0;i<threads.length;i++)
		{
			threads[i]=new SumThread(i*10000+1,(i+1)*10000);
			threads[i].start();
		}
		int result=0;
		for(int i=0;i<threads.length;i++)
		{
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result+=threads[i].getResult();
		}
		System.out.println(result);
		long end=System.nanoTime();
		System.out.println(end-start);
		start=System.nanoTime();
		result=0;
		for(int i=1;i<=100000;i++)
		{
			result+=Math.sqrt(Math.sqrt(i));
		}
		System.out.println(result);
		end=System.nanoTime();
		System.out.println(end-start);
			
	}

}
