public class BankAccount {
	private String accountHolderName;
	private int accountNumber;
	private double balance;

	public BankAccount(String accountHolderName, double initialBalance) {
		this.accountHolderName = accountHolderName;
		this.balance = initialBalance;
		this.accountNumber = (int) (Math.random() * 1000);
	}

	public String getAccountHolder() {
		return this.accountHolderName;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}

	public boolean withdraw(double amount) {
		boolean hasEnoughMoney = balance >= amount;

		if (hasEnoughMoney) {
			balance -= amount;
		}

		return hasEnoughMoney;
	}

	public void checkBalance() {
		// System.out.printf("Account Holder Name: %s%n", accountHolderName);
		System.out.printf("Balance: $%.2f", balance);
	}

	public String toString() {
		return String.format("Account Number: %s%nAccount Holder: %s%nBalance: $%.2f%n", accountNumber, accountHolderName, balance);
	}
}