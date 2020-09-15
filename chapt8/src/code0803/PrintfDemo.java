package code0803;
import java.util.Date;
public class PrintfDemo {
	public static void main(String[] args) {
		double d1 = 23456789.567;
		
		int i=65;
		// 用逗号作为分隔符, 格式化浮点数,字符
		System.out.printf("%1$,.2f\n16进制 %2$x= %2$c\n", d1,i);
		Date c =new Date();
		// 格式化日期
		System.out.printf("日期:%1$tF 时间：%1$tT %1$tA\n", c);
		String s=String.format("日期:%1$tF 时间：%1$tT %1$tA\n", c);
		System.out.println(s);
		
	}
}
