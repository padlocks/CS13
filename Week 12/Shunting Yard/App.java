import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter an infix expression to convert to postfix:");
        String infix = scanner.nextLine();

        try {
            // Convert the input infix expression to postfix
            String postfix = ShuntingYard.convertToPostfix(infix);
            // Display the postfix expression
            System.out.println("Postfix Expression: " + postfix);
        } catch (IllegalArgumentException e) {
            // Handle any exceptions during conversion
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}
