public class SavingsAccount extends BankAccount {
	private final double interestRate = 0.01;

	public SavingsAccount(String name, double initialBalance) {
		super(name, initialBalance);
	}

	public void applyInterest() {
		this.deposit(this.getBalance() * this.interestRate);
	}

	public double getInterestRate() {
		return this.interestRate;
	}
}