public class ExamSeatDuplicateChecker {

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
                    return;
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
        checkDuplicateSeats(hall1);

        int[] hall2 = {101, 102, 103, 104, 105};
        System.out.print("Hall 2: ");
        checkDuplicateSeats(hall2);
    }
}
