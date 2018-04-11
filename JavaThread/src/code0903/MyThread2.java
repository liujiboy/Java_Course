package code0903;
//实现Runnable接口
public class MyThread2 implements Runnable
{
	int count = 1, number;
	public MyThread2(int i)
	{
		number = i;
		System.out.println("创建线程 " + number);
	}
	public void run()
	{
		while (true) {
			System.out.println("线程 " + number + ":计数 " + count);
			if (++count == 6)
				return;
			{
			}
		}
	}
	public static void main(String args[])
	{
		for (int i = 0; i < 5; i++)
			//通过Thread类创建线程对象，并启动
			new Thread(new MyThread2(i + 1)).start(); 
	}
}
