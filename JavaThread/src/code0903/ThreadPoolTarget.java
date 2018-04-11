
package code0903;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTarget implements Runnable {
	private String targetName;
	Random r = new Random();

	public ThreadPoolTarget(String targetName) {
		this.targetName = targetName;
	}

	@Override
	public void run() {
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += r.nextInt(100);
		}
		System.out.println(Thread.currentThread().getName() + "执行：" + this.targetName + " 结果：" + sum);
	}

	public static void main(String[] args) {
		// 创建线程池包含2个线程
		ExecutorService pool = Executors.newFixedThreadPool(2);
		// 创建10个线程任务，并提交到线程池
		for (int i = 1; i <= 10; i++) {
			// 创建线程执行任务
			ThreadPoolTarget t = new ThreadPoolTarget("Target" + i);
			// 把任务提交到线程池
			pool.execute(t);
		}


	}
}
