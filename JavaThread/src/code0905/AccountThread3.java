package code0905;
public class AccountThread3 extends Thread {
	LockAccount account;
	int delay = 100;

	public AccountThread3(LockAccount account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		account.withdraw(1000);
	}

	public static void main(String[] args) throws InterruptedException {
		// 创建账号对象
		LockAccount account = new LockAccount(1005);
		// 创建三个取款线程
		AccountThread3 t1 = new AccountThread3(account);
		AccountThread3 t2 = new AccountThread3(account);
		AccountThread3 t3 = new AccountThread3(account);
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