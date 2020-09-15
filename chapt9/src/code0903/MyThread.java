package code0903;
// 继承Tread类
public class MyThread extends Thread
{ // count变量用于统计打印的次数并共享变量
	private static int count = 0;
	public MyThread(String name)
	{
		super(name);
	}
	public static void main(String[] args)
	{// main方法开始
		MyThread p = new MyThread("t1"); // 创建一个线程实例
		p.start(); // 执行线程
		// 主线程main方法执行一个循环
		for (int i = 0; i < 5; i++) {
			count++;
			// 主线程中打印count+“main”变量的值，并换行
			System.out.println(count + ": main");
		}
	}

	public void run()
	{// 线程类必须有的run（）方法
		for (int i = 0; i < 5; i++) {
			count++;
			System.out.println(count + ":" + this.getName());
		}
	}
}
