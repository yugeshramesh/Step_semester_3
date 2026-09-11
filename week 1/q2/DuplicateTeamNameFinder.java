public class DuplicateTeamNameFinder {

    // Compares every name against every subsequent name using nested loops
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null) return "No Duplicates Found";

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i] != null && teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] test1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(test1)); // Output: Duplicate Found: ByteForce

        String[] test2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(test2)); // Output: No Duplicates Found
    }
}
