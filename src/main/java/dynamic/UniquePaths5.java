package dynamic;

import java.util.Arrays;

public class UniquePaths5 {

    // O(w * h) time | O(w * h) space
    public static int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) return -1;

        int[][] up = new int[m][n];

        Arrays.fill(up[0], 1);

        for (int i = 0; i < m; i++) {
            up[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                up[i][j] = up[i - 1][j] + up[i][j - 1];
            }
        }

        return up[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // https://leetcode.com/problems/unique-paths/
        System.out.println(uniquePaths(3, 2)); // 3

        System.out.println(uniquePaths(3, 7)); // 28
    }
}
