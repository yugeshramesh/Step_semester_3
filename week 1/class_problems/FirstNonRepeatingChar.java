import java.util.HashMap;
import java.util.Map;

/**
 * Problem 4: First Non-Repeating Character
 * Scenario: The Unique Letter Hunt Mini-Game
 * 
 * Task:
 * - Count frequency of each character in text.
 * - Scan left-to-right to find the first character with a frequency of exactly 1.
 * - Return the character or '\0' (null character) if none found.
 */
public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Frequency array for standard ASCII characters (or HashMap for general characters)
        int[] frequency = new int[256];

        // Step 1: Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Step 2: Scan text left-to-right to find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // Return '\0' when all characters repeat
    }

    public static void test(String text) {
        char result = findFirstNonRepeatingChar(text);
        System.out.print("Input: \"" + text + "\" -> ");
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        test("swiss");   // Output: 'w'
        test("aabbcc");  // Output: No Non-Repeating Character Found
    }
}
