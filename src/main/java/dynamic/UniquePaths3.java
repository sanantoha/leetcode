package dynamic;

public class UniquePaths3 {

    // O(m * n) time | O(m * n) time
    public static int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) return -1;

        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
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
