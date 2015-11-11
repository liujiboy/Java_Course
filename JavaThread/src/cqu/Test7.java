package cqu;

public class Test7 {
	public static int n = 10;
	public static Object lock = new Object();

	public static void main(String args[]) throws InterruptedException {
		long start=System.nanoTime();
		Customer customers[] = new Customer[300000];
		for (int i = 0; i < customers.length; i++) {
			customers[i] = new Customer(i);
			customers[i].start();
		}
		int count = 0;
		for (int i = 0; i < customers.length; i++) {

			customers[i].join();
			if (customers[i].isFlag()) {
				System.out.println(customers[i].getCustomerId());
				count++;
			}
		}
		System.out.println("实际个数：" + count);
		long end=System.nanoTime();
		System.out.println(end-start);
	}
}

class Customer extends Thread {
	private int customerId;
	private boolean flag = false;

	public void run() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (Test7.lock) {
			if (Test7.n != 0) {
				flag = true;
				Test7.n--;
			}
		}
	}

	public int getCustomerId() {
		return customerId;
	}

	public boolean isFlag() {
		return flag;
	}

	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}
}
