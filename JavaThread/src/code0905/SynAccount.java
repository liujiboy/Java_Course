package code0905;

public class SynAccount {
	double balance;// 余额
	final double MAX = 10000;// 最高限额

	public SynAccount(double balance) {

		this.balance = balance;
	}

	// 存款同步方法
	public synchronized void withdraw(double money) {
		if (balance < money) {
			try {
				System.out.printf("取款%1$,.2f失败。余额：%2$,.2f\n", money, balance);
				wait();// 进入等待队列
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		balance -= money;
		System.out.printf("取款%1$,.2f成功。余额：%2$,.2f\n", money, balance);
		notify();// 唤醒等待队列的线程

	}

	// 取款同步方法
	public synchronized void deposit(double money) {
		if (balance + money >= MAX) {
			try {
				System.out.printf("存款%1$,.2f失败。余额：%2$,.2f\n", money, balance);
				wait();// 进入等待队列
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		balance += money;
		System.out.printf("存款%1$,.2f成功。余额：%2$,.2f\n", money, balance);
		notify();// 唤醒等待队列的线程

	}
}