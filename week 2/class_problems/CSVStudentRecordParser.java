/**
 * Problem 2: CSV Student Record Parser
 * Scenario: Training and Placement Registration Data
 * 
 * Task:
 * - Accept CSV line "Name,RollNumber,Department".
 * - Validate exactly 3 fields; if not, print "Invalid Record".
 * - Print formatted: "Name: ... | Roll No: ... | Dept: ...".
 */
public class CSVStudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        // Output: Name: Ananya Verma | Roll No: RA2211003010123 | Dept: CSE

        parseStudentRecord("Ananya Verma,CSE");
        // Output: Invalid Record
    }
}
