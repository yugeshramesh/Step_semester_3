/**
 * Problem 4: Masked Phone Number Formatter
 * Scenario: Student-Support Call Center Privacy Display
 * 
 * Task:
 * - Accept phone string and validate it has exactly 10 digits (all numeric).
 * - Build masked string: "XXXXXX-" followed by last 4 digits using StringBuilder.
 * - Return masked phone number or "Invalid phone number".
 */
public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validate all 10 characters are digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String last4 = phone.substring(6);
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX-").append(last4);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210")); // Output: XXXXXX-3210
        System.out.println(maskPhoneNumber("98765"));      // Output: Invalid phone number
    }
}
