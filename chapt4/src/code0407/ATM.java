/**
 * 
 */
package code0407;

/**
 * ATM.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.io.*;

class ATM {
	Account act;

	public ATM() {
		act = new Account("000", "test", "111", 5000); // 生成Account实例
	}

	/*********** 欢迎界面 ***********/
	protected void Welcome() {
		String str = "---------------------------------";
		System.out.print(str + "\n");
		System.out.print(" 1.取款." + "\n" + " 2.查询." + "\n" + " 3.存款." + "\n" + " 4.退出系统." + "\n");
		System.out.print(str + "\n");
	}

	/********** 登陆系统 **********/
	protected void Load_Sys() throws Exception {
		String card, pwd;
		int counter = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 创建标准输入输出流，详见第8章
		do {
			System.out.println("请输入您的卡号:");
			card = br.readLine(); // 读取键盘输入信息
			System.out.println("请输入您的密码:");
			pwd = br.readLine();
			if (!isRight(card, pwd)) {
				System.out.println("您的卡号或密码输入有误.");
				counter++;
			} else
				SysOpter();

		} while (counter < 3);
		System.exit(1); // 应用退出
	}

	/********** 系统操作提示 **********/
	protected void SysOpter() throws Exception {
		int num;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请选择您要操作的项目(1-4):");
		num = br.read(); // num为ASICC码转换的整数
		switch (num) {
		case 49:
			BetBalance();
			break;
		case 50:
			Inqu_Info();
			break;
		case 51:
			AddBalance();
			break;
		case 52:
			Exit_Sys();
			break;
		}
		System.exit(1);
	}

	/********** 信息查询 **********/
	protected void Inqu_Info() throws Exception {

		System.out.print("---------------------\n" + "账号:" + act.get_number() + "\n" + "姓名:" + act.get_Name() + "\n"
				+ "余额:" + act.get_Money() + "\n" + "-----------------------\n");
		SysOpter();
	}

	/********** 取款 **********/
	public void BetBalance() throws Exception {
		String str = null, str1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("请输入取款数目:");
			str = br.readLine();
			double qu = Double.valueOf(str).doubleValue(); // 将字符串转换为double类型
			if (qu > act.get_Money()) {
				System.out.println("余额不足,请重新输入您要取的数目:");
			} else {
				act.sub_Balance(qu);
				System.out.println("取款成功,您的账户余额为:" + act.get_Money());
				Welcome();
				SysOpter();
			}
		} while (true);

	}

	/********** 存款 **********/
	public void AddBalance() throws Exception {
		String str = null, str1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("请输入存款数目:");
			str = br.readLine();
			double qu = Double.valueOf(str).doubleValue();
			act.add_Balance(qu);
			System.out.println("存款成功,您的账户余额为:" + act.get_Money());
			Welcome();
			SysOpter();
		} while (true);

	}

	/********** 判断卡内是否有钱 **********/
	protected boolean isBalance() {
		if (act.get_Money() < 0) {
			return false;
		}
		return true;
	}

	/******** 卡号密码是否正确 ******/
	protected boolean isRight(String card, String pwd) {
		if (act.get_number().equals(card) && act.get_Password().equals(pwd))
			return true;
		else
			return false;
	}

	/********** 结束系统 **********/
	protected void Exit_Sys() {
		System.out.println("感谢您使用本系统,再见!");
		System.exit(1);
	}
}
