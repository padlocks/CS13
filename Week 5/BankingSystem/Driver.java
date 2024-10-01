public class Driver {
	public static void main(String[] args) {
		CheckingAccount checkingAccount = new CheckingAccount("Audrey Young", 1000.02);
		SavingsAccount savingsAccount = new SavingsAccount("Audrey Young", 0.00);

		checkingAccount.deposit(300.13);
		printAccount(checkingAccount);

		checkingAccount.transfer(savingsAccount, 1000);
		printAccount(savingsAccount);

		savingsAccount.applyInterest();
		printAccount(savingsAccount);

		savingsAccount.withdraw(350.10);
		printAccount(savingsAccount);

		checkingAccount.withdraw(2000.00);
		printAccount(checkingAccount);

		savingsAccount.deposit(100.00);
		printAccount(savingsAccount);
	}

	private static void printAccount(BankAccount account) {
		System.out.println(account);
		System.out.println("_________________");
	}
}