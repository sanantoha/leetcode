package dynamic;

import java.util.Arrays;

public class UniquePaths2 {

    // O(m * n) time | O(m * n) time
    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 1;

        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[row].length; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
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
