package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RiverSizes7 {

    // O(w * h) time | O(w * h) space
    public static List<Integer> riverSizes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    res.add(dfs(matrix, visited, i, j, 0));
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] matrix, boolean[][] visited, int row, int col, int cnt) {
        if (matrix[row][col] == 0) return cnt;
        visited[row][col] = true;
        cnt++;

        for (int[] neighbor : getNeighbors(matrix, row, col)) {
            int frow = neighbor[0];
            int fcol = neighbor[1];

            if (frow >= 0 && fcol >= 0 && frow < matrix.length && fcol < matrix[frow].length &&
                matrix[frow][fcol] == 1 && !visited[frow][fcol]) {
                cnt = dfs(matrix, visited, frow, fcol, cnt);
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
