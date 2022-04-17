package dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/explore/interview/card/apple/347/dynamic-programming/3135/
 */
public class RegularExpressionMatch {

    // O(s * p) time | O(s * p) space
    public static boolean isMatch(String s, String p) {
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p, memo);
    }

    private static boolean dp(int i, int j, String s, String p, boolean[][] memo) {
        boolean ans;
        if (!memo[i][j]) {
            if (j == p.length()) {
                ans = i == s.length();
            } else {
                boolean firstMatch = i < s.length() && Set.of(s.charAt(i), '.').contains(p.charAt(j));

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    ans = dp(i, j + 2, s, p, memo) || firstMatch && dp(i + 1, j, s, p, memo);
                } else {
                    ans = firstMatch && dp(i + 1, j + 1, s, p, memo);
                }
            }
            memo[i][j] = ans;
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(!isMatch("aa", "a"));

        System.out.println(isMatch("aa", "a*"));

        System.out.println(isMatch("abcde", ".*"));

        System.out.println(isMatch("abcde", ".*de"));

        System.out.println(!isMatch("abcde", ".*dk"));
    }
}
