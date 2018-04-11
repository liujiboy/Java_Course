package code0905;

public class SynThreads {
    
   

	public static void main(String[] args) {
		SynAccount account = new SynAccount(5000);
		Thread withdraw = new Withdrawer(account);
		Thread deposit = new Depositor(account);
		withdraw.start();
		deposit.start();
	}

}
