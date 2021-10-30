package graph;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes5 {

    // O(w * h) time | O(w * h) space
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col] && matrix[row][col] == 1) {
                    res.add(dfs(matrix, visited, row, col, 0));
                }
            }
        }


        return res;
    }

    private static int dfs(int[][] matrix, boolean[][] visited, int row, int col, int count) {
        visited[row][col] = true;
        count++;

        List<int[]> neighbors = getNeighbors(matrix, row, col);
        for (int[] neighbor : neighbors) {
            int nRow = neighbor[0];
            int nCol = neighbor[1];
            if (!visited[nRow][nCol] && matrix[nRow][nCol] == 1) {
                count = dfs(matrix, visited, nRow, nCol, count);
            }
        }
        return count;
    }

    private static List<int[]> getNeighbors(int[][] matrix, int row, int col) {
        List<int[]> neighbors = new ArrayList<>();
        if (row > 0) neighbors.add(new int[] {row - 1, col});
        if (col > 0) neighbors.add(new int[] {row, col});
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

        System.out.println(riverSizes(matrix));
    }
}
