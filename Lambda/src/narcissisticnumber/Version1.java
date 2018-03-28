package narcissisticnumber;

public class Version1 {

	public static void main(String[] args) {
		for(int i=100;i<1000;i++)
		{
			if(isNarcissisticNumber(i))
			{
				System.out.println(i);
			}
		}
	}
	public static boolean isNarcissisticNumber(int i)
	{
		int a=i/100;
		int b=(i/10)%10;
		int c=i%10;
		return a*a*a+b*b*b+c*c*c==i;
	}

}
