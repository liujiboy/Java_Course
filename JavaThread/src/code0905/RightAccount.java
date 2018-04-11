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

