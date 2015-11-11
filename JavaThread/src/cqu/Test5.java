package cqu;

public class Test5 {

	public static void main(String[] args) {
		final Object lockT1 = new Object();
		final Object lockT2 = new Object();
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					synchronized (lockT2) {
						
						synchronized (lockT1) {
							System.out.print("t1");

							lockT1.notify();
						}
						try {
							lockT2.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					synchronized (lockT1) {
						
						synchronized (lockT2) {
							System.out.print("t2");
							lockT2.notify();
						}
						try {
							lockT1.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		t1.start();
		t2.start();
	}

}
