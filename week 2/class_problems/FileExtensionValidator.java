/**
 * Problem 3: File Extension Validator
 * Scenario: Assignment-Upload Portal
 * 
 * Task:
 * - Extract extension using lastIndexOf('.') and substring().
 * - Validate against accepted extensions (pdf, docx, zip) case-insensitively.
 * - Return "Accepted" or "Rejected — invalid file type".
 */
public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "Rejected — invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');
        String ext = filename.substring(lastDotIndex + 1);

        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF")); // Output: Accepted
        System.out.println(validateFileExtension("notes.txt"));       // Output: Rejected — invalid file type
    }
}
