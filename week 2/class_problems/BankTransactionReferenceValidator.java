/**
 * Problem 5: Bank Transaction Reference Generator & Validator
 * Scenario: Fintech Onboarding Module
 * 
 * Task:
 * - Normalize reference: trim spaces and uppercase first 3 characters.
 * - Validate: exactly 14 characters; first 3 letters; next 11 digits.
 * - Format: "[BANKCODE] DATE: dd/MM/yy | SEQ: 12345" using StringBuilder.
 */
public class BankTransactionReferenceValidator {

    // Normalizes the reference code
    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    // Validates and formats the reference code
    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        String input1 = " hdf03022600042 ";
        String norm1 = normalizeReference(input1);
        System.out.println(validateAndFormat(norm1));
        // Output: [HDF] DATE: 03/02/26 | SEQ: 00042

        String input2 = "12F03022600042";
        String norm2 = normalizeReference(input2);
        System.out.println(validateAndFormat(norm2));
        // Output: Invalid: bank code must be 3 letters
    }
}
