package code0905;

//存款线程
public class Depositor extends Thread {
	SynAccount account;

	public Depositor(SynAccount account) {

		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 8; i++) {
			account.deposit(2000);
		}
	}
}