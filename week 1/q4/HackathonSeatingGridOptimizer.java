public class HackathonSeatingGridOptimizer {

    // Helper method to calculate the average score of a single row
    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    // Classifies each row in a seating grid as "Quiet Zone" or "Buzzing Zone"
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Row ").append(i).append(": ").append(zone);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;

        String result = classifyRows(seatingScores, threshold);
        System.out.println(result);
        // Output: Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone
    }
}
