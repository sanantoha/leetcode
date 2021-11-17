package dynamic;

import java.util.Arrays;

/**
 * https://www.algoexpert.io/questions/Levenshtein%20Distance
 */
public class LevenshteinDistance {

    // O(n * m) time | O(n * m) space
    public static int levenshteinDistance(String str1, String str2) {

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < str2.length() + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    // O(n * m) time | O(min(m, n)) space
    public static int levenshteinDistance1(String str1, String str2) {
        String small = (str1.length() < str2.length()) ? str1 : str2;
        String big = (str1.length() >= str2.length()) ? str1 : str2;

        int[] even = new int[small.length() + 1];
        for (int i = 0; i < even.length; i++) {
            even[i] = i;
        }
        int[] odd = new int[small.length() + 1];

        int[] current;
        int[] prev;

        for (int i = 1; i < big.length() + 1; i++) {
            if (i % 2 == 1) {
                current = odd;
                prev = even;
            } else {
                current = even;
                prev = odd;
            }
            current[0] = i;

            for (int j = 1; j < small.length() + 1; j++) {
                if (big.charAt(i - 1) == small.charAt(j - 1)) {
                    current[j] = prev[j - 1];
                } else {
                    current[j] = 1 + Math.min(Math.min(prev[j], prev[j - 1]), current[j - 1]);
                }
            }
        }

        return (big.length() % 2 == 0) ? even[small.length()] : odd[small.length()];
    }

    public static void main(String[] args) {
        System.out.println(levenshteinDistance("abc", "yabd") == 2);
        System.out.println(levenshteinDistance1("abc", "yabd") == 2);
    }
}
