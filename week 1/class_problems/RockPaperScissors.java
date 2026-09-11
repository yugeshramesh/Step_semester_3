import java.util.Random;
import java.util.Scanner;

/**
 * Problem 1: Rock-Paper-Scissors Game
 * Scenario: The College Coding Arcade
 * 
 * Task:
 * - Generate computer move randomly (Rock, Paper, or Scissors).
 * - Accept player move.
 * - Determine round outcome using standard rules.
 * - Play 5 rounds and display summary table and statistics (Win %).
 */
public class RockPaperScissors {

    // Determines the result of a single round
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        int rounds = 5;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        // Predefined demo moves or interactive input
        String[] demoPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        System.out.println("=== Starting 5-Round Rock-Paper-Scissors Game ===");

        for (int i = 0; i < rounds; i++) {
            String playerMove = demoPlayerMoves[i];
            String computerMove = moves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Round " + (i + 1) + " — Player: " + playerMove + ", Computer: " + computerMove + " -> " + result);
        }

        // Display Final Summary Table
        System.out.println("\n================ FINAL SUMMARY ================");
        System.out.println("Round\tPlayer Move\tComputer Move\tResult");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.println((i + 1) + "\t" + playerMoves[i] + "\t\t" + computerMoves[i] + "\t\t" + results[i]);
        }

        double winPercentage = ((double) wins / rounds) * 100.0;
        System.out.println("-----------------------------------------------");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + String.format("%.1f", winPercentage) + "%");

        scanner.close();
    }
}
