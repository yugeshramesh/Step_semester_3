/**
 * Assignment Problem 2: Word Reversal Encoder
 * Scenario: Coding Club "Mirror Text" Mini-Game
 * 
 * Task:
 * - Accept a sentence with words separated by single spaces.
 * - Reverse each word individually using StringBuilder.
 * - Join reversed words with spaces and return result.
 */
public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder(words[i]).reverse();
            if (i > 0) {
                result.append(" ");
            }
            result.append(reversedWord);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "hello club";
        String output = reverseEachWord(input);
        System.out.println("Input: \"" + input + "\" -> Output: \"" + output + "\"");
        // Output: olleh bulc
    }
}
