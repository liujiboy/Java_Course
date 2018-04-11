
package code0901;

public class SimpleThreadTest {
	public static void main(String[] args) {
		// 创建线程对象:
		Thread sum = new SumThread();
		Thread squareSum = new SquareSumThread();
		// 启动线程
		sum.start();
		squareSum.start();
	}
}
