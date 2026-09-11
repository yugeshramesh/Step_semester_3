import java.util.*;

/**
 * Assignment Problem 5: Stop-Word-Filtered Word Frequency Report
 * Scenario: Training & Placement Feedback Word-Frequency Analysis
 * 
 * Task:
 * - Filter stop words: {"the", "was", "and", "a", "is", "of", "in"}.
 * - Convert to lowercase, remove punctuation.
 * - Split into words and count frequencies using HashMap.
 * - Print unique words and counts sorted in descending order.
 */
public class FilteredWordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Set of stop words to exclude
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        // Normalize text: lowercase and remove punctuation
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "")
                                 .replace("!", "")
                                 .replace("?", "")
                                 .replace(";", "")
                                 .replace(":", "");

        String[] words = cleaned.trim().split("\\s+");
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        // Sort entries by count in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Print formatted result
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
        /*
         Output:
         great: 2
         mentor: 1
         session: 1
         clear: 1
        */
    }
}
