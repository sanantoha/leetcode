package dynamic;

import java.util.Arrays;

public class UniquePaths6 {

    // O(m * n) time | O(m * n) space
    public static int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) return -1;

        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // https://leetcode.com/problems/unique-paths/
        System.out.println(uniquePaths(3, 2)); // 3

        System.out.println(uniquePaths(3, 7)); // 28
    }
}
