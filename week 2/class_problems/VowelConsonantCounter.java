/**
 * Problem 1: Vowel & Consonant Counter
 * Scenario: Library Orientation Kiosk
 * 
 * Task:
 * - Loop through character by character using charAt().
 * - Count vowels (a, e, i, o, u) case-insensitively and consonants; ignore spaces.
 * - Print total vowels and consonants.
 */
public class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        String input = "Java Programming";
        System.out.print("Input: \"" + input + "\" -> ");
        countVowelsAndConsonants(input); // Output: Vowels: 5 | Consonants: 10
    }
}
