/**
 * Problem 2: Palindrome Checker (3 Approaches)
 * Scenario: The QA Text Verification Toolkit
 * 
 * Task:
 * - Implement iterative check (two-pointer inward scan)
 * - Implement recursive check (first and last char comparison)
 * - Implement array-reversal check (char array reversal)
 * - Confirm all three approaches agree on the result.
 */
public class PalindromeChecker {

    // Approach 1: Iterative two-pointer check
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive check
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        if (text.length() <= 1) return true;

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        // Recursive call with substring excluding first and last characters
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Character Array Reversal check
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return String.valueOf(original).equals(String.valueOf(reversed));
    }

    // Formatter helper
    public static String formatResult(boolean isPal) {
        return isPal ? "Palindrome" : "Not Palindrome";
    }

    public static void testString(String text) {
        boolean iter = isPalindromeIterative(text);
        boolean recur = isPalindromeRecursive(text);
        boolean arrRev = isPalindromeArrayReversal(text);

        System.out.println("Input: \"" + text + "\"");
        System.out.println("Iterative: " + formatResult(iter) + 
                           " | Recursive: " + formatResult(recur) + 
                           " | Array Reversal: " + formatResult(arrRev));
        System.out.println();
    }

    public static void main(String[] args) {
        testString("madam");
        testString("hello");
    }
}
