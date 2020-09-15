package code0803;
import java.io.IOException;
public class StdInput
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("intput:");
		byte b[] = new byte[512];
		int count = System.in.read(b);
		System.out.println("Output");
		for (int i=0;i<count;i++)
		{
			System.out.print(b[i] + " ");
		}
		System.out.println();
		for (int i=0;i<count;i++)
		{
			System.out.print((byte)b[i] + " ");
		}
		System.out.println("count=" + count);
	}
}
