/**
 * 
 */
package code0407;

import java.io.*;

/**
 * Account.java Copyright (c) 2016 ChongQing University All rights reserved.
 */

class Account {
	private String number = null; // 卡号
	private String name = null; // 客户姓名
	private String password = null; // 客户密码
	private double money = 0.0; // 余额

	/***** 构造方法，以生成多个储户信息 ***********/
	public Account(String number, String name, String password, double money) {
		this.number = number;
		this.name = name;
		this.password = password;
		this.money = money;
	}

	protected String get_number() {
		return number;
	}

	protected String get_Name() {
		return name;
	}

	protected String get_Password() {
		return password;
	}

	public double get_Money() {
		return money;
	}

	protected void sub_Balance(double mon) { // 余额减少
		money -= mon;
	}

	protected void add_Balance(double mon) { // 余额增加
		money += mon;
	}
}
