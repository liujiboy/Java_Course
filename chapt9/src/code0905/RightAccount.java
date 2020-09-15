/**
 * 
 */
package code0905;

/**
 * RightAccount.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
public class RightAccount {

	double balance;// 账号余额

	public RightAccount(double balance) {
		super();
		this.balance = balance;
	}

	// 同步方法，执行该方法时，必须获得所在对象的互斥锁
	public synchronized void withdraw(double money) {
		// 下面执行取款操作
		if (balance >= 1000) {

			try {
				Thread.sleep(100);
				balance -= 1000;
				System.out.println("取款1000成功。");
			} catch (Exception e) {

				e.printStackTrace();
			}

		} else {
			System.out.println("取款失败。");
		}
	}
}

class AccountThread2 extends Thread {
	RightAccount account;
	int delay = 100;

	public AccountThread2(RightAccount account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		account.withdraw(1000);
	}

	public static void main(String[] args) throws InterruptedException {
		// 创建账号对象
		RightAccount account = new RightAccount(1005);
		// 创建三个取款线程
		AccountThread2 t1 = new AccountThread2(account);
		AccountThread2 t2 = new AccountThread2(account);
		AccountThread2 t3 = new AccountThread2(account);
		t1.start();
		t2.start();
		t3.start();
		// 主线程等待三个线程结束后，输出最后余额
		t1.join();
		t2.join();
		t3.join();
		System.out.println("最终账号余额是：" + account.balance);
	}

}