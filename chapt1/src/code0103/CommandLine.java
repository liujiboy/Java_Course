package code0103;

public class CommandLine {
	public static void main(String[] args) {
		System.out.println("打印命令行参数");
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
}
