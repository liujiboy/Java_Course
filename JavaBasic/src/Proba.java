import javax.swing.JOptionPane;

public class Proba {
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("你希望抽取多少个数？");
		int k = Integer.parseInt(input);
		input = JOptionPane.showInputDialog("一共有多少个数");
		int n = Integer.parseInt(input);
		int result = 1;
		for (int i = 1; i <= k; i++) {
			result = result * (n - i + 1) / i;
		}
		System.out.println("你中奖的几率是1/" + result + "");
		System.exit(0);
	}
}
