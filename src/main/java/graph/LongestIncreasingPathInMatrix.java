package graph;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingPathInMatrix {

    // O(w * h) time | O(w * h) space
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int ans = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans = Math.max(dfs(matrix, cache, i, j), ans);
            }
        }

        return ans;
    }

    private static int dfs(int[][] matrix, int[][] cache, int row, int col) {
        if (cache[row][col] != 0) return cache[row][col];

        int val = matrix[row][col];

        for (int[] p : getNeighbors(matrix, row, col)) {
            int nrow = p[0];
            int ncol = p[1];
            if (matrix[nrow][ncol] > val) {
                cache[row][col] = Math.max(dfs(matrix, cache, nrow, ncol), cache[row][col]);
            }
        }
        cache[row][col]++;
        return cache[row][col];
    }

    private static List<int[]> getNeighbors(int[][] matrix, int row, int col) {
        List<int[]> res = new ArrayList<>();
        if (row > 0) res.add(new int[] {row - 1, col});
        if (col > 0) res.add(new int[] {row, col - 1});
        if (row + 1 < matrix.length) res.add(new int[] {row + 1, col});
        if (col + 1 < matrix[row].length) res.add(new int[] {row, col + 1});

        return res;
    }

    /**
     * https://leetcode.com/explore/interview/card/apple/350/trees-and-graphs/2049/
     * @param args
     */
    public static void main(String[] args) {
        int[][] input = {
                {9,9,4},{6,6,8},{2,1,1}
        };
        System.out.println(longestIncreasingPath(input)); // 4

        int[][] input1 = {
                {3,4,5},{3,2,6},{2,2,1}
        };
        System.out.println(longestIncreasingPath(input1)); // 4
    }
}
