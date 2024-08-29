import java.util.*;

public class SoloDiceDuel {
	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();
	static boolean playing = false;
	static String input = "";
	// static String[] validInputs = {"b, r"};
	static int[] addTenPoints = {7,11};
	static int[] loseFivePoints = {2,3,12};
	static int lastRoll = 0;
	static boolean rolledPoint = false;
	static int points = 0;
	static int bank = 0;

	public static void main(String[] args) {
		// Scanner and intro
		System.out.println("Your goal is to reach 100 points");
		System.out.println("Enter to start playing.");
		input = scanner.nextLine();

		if (input.equals("")) {
			// Start game loop
			playing = true;
                    OUTER:
                    while (playing) {
                        System.out.println("Points: " + points + " Banked: " + bank);
                        System.out.println("r to roll, b to bank current points, s to stop");
                        try {
                            input = scanner.next();
                            
                            // if (!validInputs.includes(input)) {
                            // 	System.out.println("Not a valid input.");
                            // 	continue;
                            // }
                        } catch (InputMismatchException e) {
                            System.out.println("Must be a letter.");
                            continue;
                        }
                        switch (input) {
                            case "r":
                                // Rolling
                                int roll = rollDice();
                                // Initial roll
                                if (points == 0) {
                                    handleInitialRoll(roll);
                                }
                                if (roll == lastRoll) {
                                    points += 5;
                                    rolledPoint = true;
                                }
                                // Set last roll
                                lastRoll = roll;
                                if (roll == 7 && !rolledPoint) {
                                    points -= 10;
                                    System.out.println("Rolled a 7 before the Point.");
                                    continue;
                                }
                                System.out.println("Rolled: " + roll + " Points: " + points);
                                break;
                            case "b":
                                bankPoints();
                                System.out.println("You have " + bank + " banked points.\nWould you like to play Double or Nothing?");
                                System.out.println("Rolling a 7 or 11 will double your banked points.\nRolling a 2, 3, or 12 will cause you to lose your banked points.");
                                System.out.println("Would you like to play? y or n");
                                input = scanner.next();
                                
                                if (input.equals("y")) {
                                    doubleOrNothing();
                                }
                                
                                continue;
                            case "s":
                                System.out.println("Game has stopped. You lose!");
                                break OUTER;
                            default:
                                continue;
                        }
                        if (points == 100) {
                            // Win condition met
                            System.out.println("You have reached 100 points, you win!");
                            break;
                        }
                    }	
		}
	}

	public static int rollDice() {
		int firstDice = random.nextInt(6) + 1;
		int secondDice = random.nextInt(6) + 1;
		return firstDice + secondDice;
	}

	public static void handleInitialRoll(int roll) {
		if (Arrays.binarySearch(addTenPoints, roll) >= 0) {
			points += 10;
		}
		else if (Arrays.binarySearch(loseFivePoints, roll) >= 0) {
			points -= 5;
		}
		else {
			points = roll;
		}
	}

	public static void bankPoints() {
		bank += points;
		points = 0;
	}

	public static void doubleOrNothing() {
		int roll = rollDice();

		if (Arrays.binarySearch(addTenPoints, roll) >= 0) {
			bank *= 2;
			System.out.println("Rolled: " + roll + " Doubled your bank!");
		}
		else if (Arrays.binarySearch(loseFivePoints, roll) >= 0) {
			bank = 0;
			System.out.println("Rolled: " + roll + " Lost everything..");
		}
	}
}