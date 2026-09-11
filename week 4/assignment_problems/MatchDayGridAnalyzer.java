/**
 * Assignment Problem 4: Match Day Grid Analyzer
 * 
 * Scenario:
 * Reusable helper method rowAverage computes average runs for each match row.
 * Classifies matches as "Power Surge" (>= threshold) or "Normal".
 */
public class MatchDayGridAnalyzer {

    // Computes average runs of one match
    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    // Classifies each match
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Match ").append(i).append(": ").append(status);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;

        String result = classifyMatches(runsPerOver, threshold);
        System.out.println(result);
        // Output: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}
