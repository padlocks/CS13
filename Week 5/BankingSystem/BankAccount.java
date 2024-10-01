class BankAccount {
	private final String accountHolder;
	private final int accountNumber;
	private double balance;

    public BankAccount(String name, double initialBalance) {
		this.accountHolder = name;
		this.balance = initialBalance;
		this.accountNumber = (int) (Math.random() * 1000);
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

	public double getBalance() {
		return this.balance;
	}

	public void transfer(BankAccount toAccount, double amount) {
		if (this.withdraw(amount)) {
			toAccount.deposit(amount);
		}
	}

    @Override
	public String toString() {
		return String.format("Account Number: %s%nAccount Holder: %s%nBalance: $%.2f%n", accountNumber, accountHolder, balance);
	}
	
}