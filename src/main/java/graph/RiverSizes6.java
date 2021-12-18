package graph;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes6 {

    // O(w * h) time | O(w * h) space
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    res.add(dfs(matrix, visited, i, j, 0));
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] matrix, boolean[][] visited, int row, int col, int cnt) {
        visited[row][col] = true;
        cnt++;

        for (int[] pair : getNeighbors(matrix, row, col)) {
            int nRow = pair[0];
            int nCol = pair[1];
            if (!visited[nRow][nCol] && matrix[nRow][nCol] == 1) {
                cnt = dfs(matrix, visited, nRow, nCol, cnt);
            }
        }
        return cnt;
    }

    private static List<int[]> getNeighbors(int[][] matrix, int row, int col) {
        List<int[]> neighbors = new ArrayList<>();
        if (row > 0) neighbors.add(new int[] {row - 1, col});
        if (col > 0) neighbors.add(new int[] {row, col - 1});
        if (row + 1 < matrix.length) neighbors.add(new int[] {row + 1, col});
        if (col + 1 < matrix[row].length) neighbors.add(new int[] {row, col + 1});
        return neighbors;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };

        System.out.println(riverSizes(matrix)); // [2, 1, 5, 2, 2]
    }
}
