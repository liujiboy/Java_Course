package cqu;

public class SumThread extends Thread {
	private int from;
	private int to;
	private int result=0;
	public SumThread(int from,int to)
	{
		this.from=from;
		this.to=to;
	}
	public void run()
	{
		for(int i=from;i<=to;i++)
		{
			result+=Math.sqrt(Math.sqrt(i));
		}
	}
	public int getResult() {
		return result;
	}
	
	
}
