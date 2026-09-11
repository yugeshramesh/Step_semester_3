/**
 * Problem 3: BMI Calculator for a Team
 * Scenario: The Corporate Wellness Program
 * 
 * Task:
 * - Calculate BMI = weight / (height * height)
 * - Classify BMI status (<18.5: Underweight, 18.5-24.9: Normal, 25-29.9: Overweight, >=30: Obese)
 * - Display a formatted report table for the entire team.
 */
public class BMICalculator {

    // Returns health status based on standard BMI thresholds
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Computes and prints the wellness report for an entire team
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid or mismatched team data.");
            return;
        }

        System.out.println("================================ CORPORATE WELLNESS REPORT ================================");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-15s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double height = heights[i];
            double weight = weights[i];
            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-10.2f | %-15s%n", 
                              (i + 1), height, weight, bmi, status);
        }
        System.out.println("===========================================================================================");
    }

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70};
        double[] weights = {70.0, 90.0, 60.0, 80.0, 68.0};

        printWellnessReport(heights, weights);
    }
}
