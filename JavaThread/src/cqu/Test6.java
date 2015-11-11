package cqu;

public class Test6 {

	public static void main(String[] args) throws InterruptedException {
		final Object lockT1 = new Object();
		final Object lockT2 = new Object();
		final Object lockT3 = new Object();
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					synchronized (lockT3) {
						synchronized (lockT1) {
							System.out.print("t1");
							lockT1.notify();
						}
						try {
							lockT3.wait();
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
		Thread t3 = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					synchronized (lockT2) {
						synchronized (lockT3) {
							System.out.print("t3");
							lockT3.notify();
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
		t1.start();
		Thread.sleep(50);
		t2.start();
		Thread.sleep(50);
		t3.start();

	}

}