package array;

import java.util.*;

/**
 * https://www.algoexpert.io/questions/stable-internships
 */
public class StableInternships1 {

    private static int[][] stableInternships(int[][] interns, int[][] teams) {
        return null;
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
