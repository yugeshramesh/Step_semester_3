import java.util.Arrays;

/**
 * Week 5 - Class Problem 1 (Easy): Hackathon Score Curve Booster
 * 
 * Scenario:
 * The judging panel at a campus hackathon wants to give every team a flat bonus
 * before the final leaderboard is printed. Boost every score in place — no new array,
 * no return value needed — and print using Arrays.toString().
 */
public class HackathonScoreCurveBooster {

    // Modifies the caller's original array directly in place
    public static void curveScores(int[] scores, int bonus) {
        if (scores == null) return;
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores)); // Output: [80, 95, 70]
    }
}
