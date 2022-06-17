package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RiverSizes {

    // O(w * h) time | O(w * h) space
    public static List<Integer> riverSizes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    res.add(dfs(matrix, visited, i, j));
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] matrix, boolean[][] visited, int row, int col) {
        int count = 1;
        visited[row][col] = true;

        for (int[] neighbor : getNeighbors(matrix, row, col)) {
            int nrow = neighbor[0];
            int ncol = neighbor[1];
            if (matrix[nrow][ncol] == 1 && !visited[nrow][ncol]) {
                count += dfs(matrix, visited, nrow, ncol);
            }
        }

        return count;
    }

    private static List<int[]> getNeighbors(int[][] matrix, int row, int col) {
        List<int[]> n = new ArrayList<>();
        if (row > 0) n.add(new int[] {row - 1, col});
        if (col > 0) n.add(new int[] {row, col - 1});
        if (row + 1 < matrix.length) n.add(new int[] {row + 1, col});
        if (col + 1 < matrix[row].length) n.add(new int[] {row, col + 1});
        return n;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        // [2, 1, 5, 2, 2]
        System.out.println(riverSizes(matrix));
    }
}
