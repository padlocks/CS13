import java.util.Scanner;

public class YoungWheelOfMisfortune {

	// Constants
	final static String[] PHRASES = {"JAVA PROGRAMMING", "I LIKE COFFEE", "TEA IS BETTER"};
	final static String[] WHEEL = {"50", "100", "250", "500", "LOSE TURN", "BANKRUPTCY"};
	final static String[] VOWELS = {"A", "E", "I", "O", "U"};
	final static int BUY_VOWEL = 250;

	// Class Variables
	static boolean playing = true;
	static String chosenPhrase = "";
	static String hiddenPhrase = "";
	static int points = 0;
	static int turns = 10;

	public static void main(String[] args) {
		randomizePhrase();

		System.out.println("Welcome to the Wheel of Misfortune!");
		System.out.println("Puzzle: " + hiddenPhrase);

		Scanner scanner = new Scanner(System.in);

		// Game Loop
		while (playing) {
			// Wheel spin
			spinWheel();

			// User input
			System.out.println("Guess a letter: ");
			String guess = scanner.nextLine().toUpperCase();

			// Validate the guess
			if (validateGuess(guess)) {
				// Fill out the puzzle
				System.out.println("Guess: The player guesses '" + guess + "'");
				fillOutPuzzle(guess);
			}

			// Display the puzzle
			System.out.println("Puzzle: " + hiddenPhrase);
			System.out.println("Points: " + points);
			System.out.println("Turns left: " + turns);

			// Check for win/lose condition
			if (hiddenPhrase.equals(chosenPhrase)) {
				System.out.println("Congratulations! You solved the puzzle!");
				playing = false;
			}
			else if (turns == 0) {
				System.out.println("Game Over! You ran out of turns.");
				playing = false;
			}
		}
	}

	private static void randomizePhrase() {
		int randomIndex = (int) (Math.random() * PHRASES.length);
		chosenPhrase = PHRASES[randomIndex];
		hiddenPhrase = chosenPhrase.replaceAll("[A-Z]", "_");
	}

	private static void fillOutPuzzle(String guess) {
		// Check if guess is equal to the word
		if (guess.equals(chosenPhrase)) {
			hiddenPhrase = chosenPhrase;
			return;
		}

		// Check if the guess is part of the phrase
		if (chosenPhrase.contains(guess)) {
			// Fill out the puzzle one letter at a time
			for (int i = 0; i < chosenPhrase.length(); i++) {
				if (chosenPhrase.charAt(i) == guess.charAt(0)) {
					// I hate substrings 🤷‍♀️
					hiddenPhrase = hiddenPhrase.substring(0, i) + guess + hiddenPhrase.substring(i + 1);
				}
			}
		}
		else {
			// Letter not found, lose a turn.
			turns--;
		}
	}

	private static void spinWheel() {
		int randomIndex = (int) (Math.random() * WHEEL.length);
		String wheelValue = WHEEL[randomIndex];

		System.out.println("Wheel Spin: The player spins the wheel and lands on " + wheelValue);

		switch (wheelValue) {
			case "100" -> points += 100;
			case "250" -> points += 250;
			case "500" -> points += 500;
			case "750" -> points += 750;
			case "LOSE TURN" -> turns--;
			case "BANKRUPTCY" -> {
				System.out.println("Wheel Spin: Points set to 0, spinning again..");
				points = 0;
				spinWheel();
			}
		}

		// System.out.println("Points: " + points);
		// System.out.println("Turns left: " + turns);
	}

	private static boolean validateGuess(String guess) {
		boolean isValid = false;

		// Check if guess is the entire phrase
		if (guess.equals(chosenPhrase)) {
			System.out.println("Guess: The player guesses the entire phrase.");
			return true;
		}

		// Check if the guess is a single letter
		if (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) {
			System.out.println("Guess: Invalid guess. Please enter a single letter.");
		}
		else {
			isValid = true;
		}

		// Check if the guess is a vowel
		for (String vowel : VOWELS) {
			if (guess.equals(vowel)) {
				if (points >= BUY_VOWEL) {
					System.out.println("Guess: The player buys a vowel for 250 points.");
					points -= BUY_VOWEL;
				}
				else {
					System.out.println("Guess: Insufficient points to buy a vowel.");
					isValid = false;
				}
			}
		}

		return isValid;
	}
}