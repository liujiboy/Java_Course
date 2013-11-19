package cqu;
public class NotifyTest {
	static int value=0;
	public static void main(String[] args) throws InterruptedException {
		final Object lock=new Object();
		Thread wait=new Thread(){
			public void run(){
				synchronized(lock)
				{
					System.out.println("begin to wait value.");
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("value="+value);		
				}
			}
		};
		Thread main=new Thread(){
			public void run(){
				synchronized(lock)
				{
					value=10;
					lock.notify();		
				}
			}
		};
		main.start();
		wait.start();
		
		
	}

}