package dynamic;

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

    // O(s * p) time | O(s * p) space
    public static boolean isMatchIter(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < s.length() && Set.of(s.charAt(i), '.').contains(p.charAt(j));

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(!isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("abcde", ".*"));
        System.out.println(isMatch("abcde", ".*de"));
        System.out.println(!isMatch("abcde", ".*dk"));

        System.out.println("======================================");

        System.out.println(!isMatchIter("aa", "a"));
        System.out.println(isMatchIter("aa", "a*"));
        System.out.println(isMatchIter("abcde", ".*"));
        System.out.println(isMatchIter("abcde", ".*de"));
        System.out.println(!isMatchIter("abcde", ".*dk"));
    }
}
