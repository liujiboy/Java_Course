package cqu;

public class Test2 {
	private static int a=0;
	public synchronized static void inc()
	{
		a++;
	}
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++)
					inc();
			}
		};
		Thread t2=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++)
					inc();
			}
		};
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(a);

	}

}
