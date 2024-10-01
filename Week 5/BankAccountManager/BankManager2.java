
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankManager2 {
	static Scanner scanner = new Scanner(System.in);
	static boolean running = true;
	static ArrayList<BankAccount> accounts = new ArrayList<>();
	static BankAccount selectedAccount;
	static boolean accountCreated = false;

	public static void main(String[] args) {
		// Loop
		try {
			while (running) {
				// Menu
				System.out.println("\nBank Manager");
				System.out.println("1. Create Account");
				System.out.println("2. Deposit money");
				System.out.println("3. Withdraw money");
				System.out.println("4. Check account balance");
				System.out.println("5. Select an account");
				System.out.println("6. List all account holders");
				System.out.println("7. Exit");

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
						System.out.print("Enter the name of the account: ");
						String name = scanner.nextLine();
						selectAccount(name);
						break;
					case 6:
						for (BankAccount account: accounts) {
							System.out.println(account.getAccountHolder());
						}
						break;
					case 7:
						exit();
						break;
					default:
						System.out.println("Invalid choice.");
						break;
						
				}
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid choice, exiting Bank Manager.");
		}
	}

	static void createAccount() {
		System.out.print("Enter name: ");
        String name = scanner.nextLine();

		System.out.print("Enter initial balance: ");
		double balance = scanner.nextDouble();
		scanner.nextLine(); // Consume next line;

		selectedAccount = new BankAccount(name, balance);
		accounts.add(selectedAccount);
		accountCreated = true;

		System.out.println("Account created!\n" + selectedAccount);
	}

	static boolean doesAccountExist() {
		if (!accountCreated)
			System.out.println("Create an account first.");
		
		return accountCreated;
	}

	static void selectAccount(String name) {
		for (BankAccount account: accounts) {
			String accountHolder = account.getAccountHolder();
			if (accountHolder.equalsIgnoreCase(name)) {
				selectedAccount = account;
				System.out.println("Account selected: " + name);
				return;
			}
		}

		System.out.println("Could not find an account with name: " + name);
	}

	static void exit() {
		System.out.println("Exiting Bank Manager..");
		running = false;
	}
}