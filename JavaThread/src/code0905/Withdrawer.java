package code0905;

//取款线程
public class Withdrawer extends Thread {
	SynAccount account;

	/**
	 * @param account
	 */
	public Withdrawer(SynAccount account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 8; i++) {
			account.withdraw(2000);
		}
	}

}