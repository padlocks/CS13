import java.util.InputMismatchException;
import java.util.Scanner;

public class YoungCaesarCipher {
	// Scanner
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Get the text and shift value from the user
		System.out.print("Enter some text: ");
		String text = scanner.nextLine();

		int shift = 0;
		boolean validShift = false;
		// Validate the shift value
		while (!validShift) {
			try {
				System.out.print("Enter the shift value (1-25): ");
				shift = scanner.nextInt();
				// Check if the shift value is between 1 and 25
				if (shift >= 1 && shift <= 25) {
					validShift = true;
				} else {
					System.out.println("Invalid shift value. Please enter a value between 1 and 25.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter an integer.");
				// Clear the input buffer
				scanner.nextLine();
			}
		}

		scanner.close();

		String encryptedText = encrypt(text, shift);
		System.out.println("Encrypted text: " + encryptedText);

		String decryptedText = decrypt(encryptedText, shift);
		System.out.println("Decrypted text: " + decryptedText);
	}

	public static String encrypt(String text, int shift) {
		String encrypted = "";

		// Loop through each character in the text
		for (int i = 0; i < text.length(); i++) {
			char character = text.charAt(i);
			if (Character.isUpperCase(character)) {
				// Encrypt uppercase letters
				char encryptedCharacter = (char) (((character - 'A') + shift) % 26 + 'A');
				encrypted += encryptedCharacter;
			} else if (Character.isLowerCase(character)) {
				// Encrypt lowercase letters
				char encryptedCharacter = (char) (((character - 'a') + shift) % 26 + 'a');
				encrypted += encryptedCharacter;
			} else {
				encrypted += character;
			}
		}
		return encrypted;
	}

	public static String decrypt(String text, int shift) {
		// Decrypt is the same as encrypting with 26 - shift
		return encrypt(text, 26 - shift);
	}
}