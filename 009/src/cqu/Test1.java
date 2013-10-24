package cqu;

public class Test1 {

	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable(){
			public void run() {
				while(true)
				{
					System.out.println("t1");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread t2=new Thread(){
			public void run()
			{
				while(true)
				{
					System.out.println("t2");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		t2.start();
		while(true)
		{
			System.out.println("main");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
