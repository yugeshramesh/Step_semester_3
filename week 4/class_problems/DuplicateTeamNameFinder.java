/**
 * Problem 2 (Easy): Duplicate Team Name Finder
 * 
 * Scenario:
 * Hackathon organizers suspect a team submitted their name twice under different entries.
 * Compare every name against every subsequent name using plain nested loops (no Collections).
 */
public class DuplicateTeamNameFinder {

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
        String[] teamList1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(teamList1)); // Output: Duplicate Found: ByteForce

        String[] teamList2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(teamList2)); // Output: No Duplicates Found
    }
}
