/**
 * Problem 5: Reverse Customer Name
 * Scenario: The Customer Identity Verification System
 * 
 * Task:
 * - Accept customerName and reverse character sequence without modifying original.
 * - Return reversed string.
 * - Print both original and reversed names in main.
 */
public class ReverseCustomerName {

    // Reverses a given customer name string
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String originalName = "Sunil";
        String reversedName = reverseCustomerName(originalName);

        System.out.println("Original Name: " + originalName);
        System.out.println("Reversed Name: " + reversedName);
        // Output:
        // Original Name: Sunil
        // Reversed Name: linuS
    }
}
