/**
 * Assignment Problem 3: The Traffic Signal Streak Analyzer
 * Scenario: City Traffic Control Department
 * 
 * Task:
 * - Scan signalLog to track length of consecutive identical characters.
 * - Find and print color and length of longest streak.
 */
public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal log provided.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestColor = currentColor;
                }
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }
        }

        // Check the last streak
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR"); // Output: Longest Streak: 'G' repeated 3 times
        findLongestStreak("RRRRYYGG"); // Output: Longest Streak: 'R' repeated 4 times
    }
}
