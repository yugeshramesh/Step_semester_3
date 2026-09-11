public class TypingSpeedAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input strings.");
            return;
        }

        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origMismatchChar = ' ';
        char typedMismatchChar = ' ';

        int minLen = Math.min(original.length(), typed.length());

        for (int i = 0; i < minLen; i++) {
            char origChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (origChar == typedChar) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origMismatchChar = origChar;
                typedMismatchChar = typedChar;
            }
        }

        double accuracy = total > 0 ? ((double) matched / total) * 100.0 : 0.0;

        StringBuilder sb = new StringBuilder();
        sb.append("Matched: ").append(matched).append("/").append(total)
          .append(" | Accuracy: ").append(String.format("%.2f", accuracy)).append("% | ");

        if (firstMismatchPos != -1) {
            sb.append("First Mismatch at position ").append(firstMismatchPos)
              .append(" ('").append(origMismatchChar).append("' vs '").append(typedMismatchChar).append("')");
        } else {
            sb.append("No Mismatches");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");

        checkTypingAccuracy("coding", "coding");

    }
}
