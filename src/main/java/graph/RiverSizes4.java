package graph;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes4 {

    private static List<Integer> riverSizes(int[][] matrix) {
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

    private static int dfs(int[][] matrix, boolean[][] visited, int row, int col, int len) {
        if (visited[row][col]) return len;
        visited[row][col] = true;
        len++;

        List<int[]> steps = getNextSteps(matrix, row, col);
        for (int[] step : steps) {
            int futRow = step[0];
            int futCol = step[1];
            if (!visited[futRow][futCol] && matrix[futRow][futCol] == 1) {
                len = dfs(matrix, visited, futRow, futCol, len);
            }
        }

        return len;
    }

    private static List<int[]> getNextSteps(int[][] matrix, int row, int col) {
        List<int[]> res = new ArrayList<>();
        if (row - 1 >= 0) res.add(new int[] {row - 1, col});
        if (col - 1 >= 0) res.add(new int[] {row, col - 1});
        if (row + 1 < matrix.length) res.add(new int[] {row + 1, col});
        if (col + 1 < matrix[row].length) res.add(new int[] {row, col + 1});
        return res;
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
