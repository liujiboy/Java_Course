package code0905;
public class AccountThread2 extends Thread {
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