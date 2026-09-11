/**
 * Assignment Problem 1: The Exam Hall Seat Duplication Checker
 * Scenario: The Examination Cell
 * 
 * Task:
 * - Accept an array of seat numbers.
 * - Compare seat numbers using nested loops (no Collections allowed).
 * - Print duplicated seat number(s) or "No Duplicate Seats Found".
 */
public class ExamSeatDuplicateChecker {

    // Scans for duplicate seat numbers using nested loops
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length < 2) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean foundDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    return; // Early return on first duplicate found
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] hall1 = {101, 102, 103, 102, 105};
        System.out.print("Hall 1: ");
        checkDuplicateSeats(hall1); // Output: Duplicate Seat Number Found: 102

        int[] hall2 = {101, 102, 103, 104, 105};
        System.out.print("Hall 2: ");
        checkDuplicateSeats(hall2); // Output: No Duplicate Seats Found
    }
}
