import java.util.HashMap;
import java.util.Map;

public class Operator {
    // Maps to store operator precedence and associativity
    private static final Map<Character, Integer> precedence = new HashMap<>();
    private static final Map<Character, Boolean> rightAssociative = new HashMap<>();

    // Static block to initialize operator properties
    static {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);
        rightAssociative.put('^', true);
    }

    public static boolean isOperator(char c) {
        return precedence.containsKey(c);
    }

    public static int getPrecedence(char c) {
        return precedence.getOrDefault(c, -1);
    }

    public static boolean isRightAssociative(char c) {
        return rightAssociative.getOrDefault(c, false);
    }
}
