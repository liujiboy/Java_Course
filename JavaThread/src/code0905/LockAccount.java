/**
 * 
 */
package code0905;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReLock.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class LockAccount {
	double balance;// 账号余额
	Lock lock = new ReentrantLock();// 创建锁对象

	public LockAccount(double balance) {
		super();
		this.balance = balance;
	}

	// 使用显示锁
	public void withdraw(double money) {

		lock.lock();// 锁定
		try {

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

		} finally {
			lock.unlock();// 释放锁
		}
	}
}


