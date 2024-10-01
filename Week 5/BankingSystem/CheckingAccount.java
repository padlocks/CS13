public class CheckingAccount extends BankAccount {
	private final double overdraftLimit = 500.0;

	public CheckingAccount(String name, double initialBalance) {
		super(name, initialBalance);
	}

	@Override
	public boolean withdraw(double amount) {
		double balance = this.getBalance();
		boolean hasEnoughMoney = (balance + this.overdraftLimit) >= amount;

		if (hasEnoughMoney) {
			// cursed but alright..
			this.deposit(-amount);
		}

		return hasEnoughMoney;
	}

	public double getOverdraftLimit() {
		return this.overdraftLimit;
	}
}