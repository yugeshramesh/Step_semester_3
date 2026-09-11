/**
 * Assignment Problem 5: The Movie Review Word Length Profiler
 * Scenario: Movie-Review Content Moderation
 * 
 * Task:
 * - Split review into words.
 * - Categorize: Short (1-4 letters), Medium (5-8 letters), Long (9+ letters).
 * - Print counts for Short, Medium, and Long words.
 */
public class MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Clean extra punctuation and split by whitespace
        String[] words = review.replaceAll("[^a-zA-Z0-9\\s]", "").trim().split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortWords++;
            } else if (len >= 5 && len <= 8) {
                mediumWords++;
            } else if (len >= 9) {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords + " | Medium: " + mediumWords + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        String review = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(review);
        // Output: Short: 3 | Medium: 1 | Long: 3
    }
}
