/**
 * Assignment Problem 4: Library ISBN Normalizer & Validator
 * Scenario: Library Book-Intake Scanner
 * 
 * Task:
 * - Normalize: trim spaces, uppercase first 3 characters using substring().
 * - Validate: 13 chars total, first 3 letters, remaining 10 digits (no regex).
 * - Format: "[PUBCODE] YEAR: 20XX | CATALOG: 123456"
 * - Output specific error reasons if invalid.
 */
public class LibraryISBNNormalizer {

    public static String normalizeCode(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        String test1 = " pen2026004251 ";
        String norm1 = normalizeCode(test1);
        System.out.println(validateAndFormat(norm1)); 
        // Output: [PEN] YEAR: 2026 | CATALOG: 004251

        String test2 = "12N2026004251";
        String norm2 = normalizeCode(test2);
        System.out.println(validateAndFormat(norm2)); 
        // Output: Invalid: publisher code must be 3 letters
    }
}
