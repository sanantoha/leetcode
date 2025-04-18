package top.interview.question.medium.dynamic;

import java.util.Arrays;

class Solution1 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}

public class UniquePaths {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        System.out.println(s.uniquePaths(3, 2)); // 3

        System.out.println(s.uniquePaths(3, 7)); // 28
    }
}
