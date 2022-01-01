package dynamic;

import java.util.Arrays;

public class UniquePaths4 {

    // O(n * m) time | O(n * m) space
    public static int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) return -1;
        int[][] paths = new int[m][n];
        Arrays.fill(paths[0], 1);
        for (int i = 0; i < paths.length; i++) {
            paths[i][0] = 1;
        }

        for (int i = 1; i < paths.length; i++) {
            for (int j = 1; j < paths[i].length; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // https://leetcode.com/problems/unique-paths/
        System.out.println(uniquePaths(3, 2)); // 3

        System.out.println(uniquePaths(3, 7)); // 28
    }
}
