package code0901;
// 继承Thread创建线程
public class SumThread extends Thread {
	public void run() {
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum += i * i;
		}
		System.out.println("平方和:" + sum);
	}
}