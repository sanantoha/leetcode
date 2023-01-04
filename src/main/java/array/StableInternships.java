package array;

import java.util.*;

/**
 * https://www.algoexpert.io/questions/stable-internships
 */
public class StableInternships {

    // O(n ^ 2) time | O(n ^ 2) space
    private static int[][] stableInternships(int[][] interns, int[][] teams) {
        Map<Integer, Integer> chosenInterns = new HashMap<>();
        Deque<Integer> freeInterns = new LinkedList<>();
        for (int i = 0; i < interns.length; i++) {
            freeInterns.push(i);
        }

        int[] currentInternChoices = new int[interns.length];
        Arrays.fill(currentInternChoices, 0);

        List<Map<Integer, Integer>> teamMaps = new ArrayList<>();
        for (int[] team : teams) {
            Map<Integer, Integer> rank = new HashMap<>();
            for (int i = 0; i < team.length; i++) {
                rank.put(team[i], i);
            }
            teamMaps.add(rank);
        }

        while (!freeInterns.isEmpty()) {
            int internNum = freeInterns.poll();

            int[] intern = interns[internNum];
            int teamPreference = intern[currentInternChoices[internNum]];
            currentInternChoices[internNum]++;

            if (!chosenInterns.containsKey(teamPreference)) {
                chosenInterns.put(teamPreference, internNum);
                continue;
            }

            int previousIntern = chosenInterns.get(teamPreference);
            int previousInternRank = teamMaps.get(teamPreference).get(previousIntern);
            int currentInternRank = teamMaps.get(teamPreference).get(internNum);

            if (currentInternRank < previousInternRank) {
                chosenInterns.put(teamPreference, internNum);
                freeInterns.push(previousIntern);
            } else {
                freeInterns.push(internNum);
            }
        }

        int[][] matches = new int[interns.length][2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : chosenInterns.entrySet()) {
            matches[idx++] = new int[] {entry.getValue(), entry.getKey()};
        }
        return matches;
    }

    public static void main(String[] args) {
        int[][] interns = new int[][] {{0, 1, 2}, {0, 2, 1}, {1, 2, 0}};
        int[][] teams = new int[][] {{2, 1, 0}, {0, 1, 2}, {0, 1, 2}};
        int[][] expected = new int[][] {{0, 1}, {1, 0}, {2, 2}};
        var actual = stableInternships(interns, teams);
        System.out.println(Arrays.deepToString(actual));

        System.out.println(expected.length == actual.length);

        for (int[] match : expected) {
            boolean containsMatch = false;
            for (int[] actualMatch : actual) {
                if (actualMatch[0] == match[0] && actualMatch[1] == match[1]) {
                    containsMatch = true;
                }
            }
            System.out.println(containsMatch);
        }
    }
}
