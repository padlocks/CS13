
import java.util.Scanner;

public class BankManager {
	static Scanner scanner = new Scanner(System.in);
	static boolean running = true;
	static BankAccount selectedAccount;
	static boolean accountCreated = false;

	public static void main(String[] args) {
		// Loop
		while (running) {
			// Menu
			System.out.println("\nBank Manager");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit money");
			System.out.println("3. Withdraw money");
			System.out.println("4. Check account balance");
			System.out.println("5. Exit");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume next line
			
			switch (choice) {
				case 1:
					createAccount();
					break;
				case 2:
					if (doesAccountExist()) {
						System.out.print("How much would you like to deposit? ");
						double amount = scanner.nextDouble();
						scanner.nextLine(); // Consume nextLine

						selectedAccount.deposit(amount);
					}
					break;
				case 3:
					if (doesAccountExist()) {
						System.out.print("How much would you like to withdraw? ");
						double amount = scanner.nextDouble();
						scanner.nextLine(); // Consume nextLine

						if (!selectedAccount.withdraw(amount)) {
							System.out.println("You do not have enough money to withdraw $" + amount);
						}
					}
					break;
				case 4:
					if (doesAccountExist()) {
						selectedAccount.checkBalance();
					}
					break;
				case 5:
					exit();
					break;
				default:
					System.out.println("Invalid choice.");
					break;
					
			}
		}
	}

	static void createAccount() {
		System.out.print("Enter name: ");
        String name = scanner.nextLine();

		System.out.print("Enter initial balance: ");
		double balance = scanner.nextDouble();
		scanner.nextLine(); // Consume next line;

		selectedAccount = new BankAccount(name, balance);
		accountCreated = true;

		System.out.println("Account created!\n" + selectedAccount);
	}

	static boolean doesAccountExist() {
		if (!accountCreated)
			System.out.println("Create an account first.");
		
		return accountCreated;
	}

	static void exit() {
		System.out.println("Exiting Bank Manager..");
		running = false;
	}
}