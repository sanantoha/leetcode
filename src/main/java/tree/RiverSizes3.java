package tree;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes3 {

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return sizes;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col] && matrix[row][col] == 1) {
                    int len = dfs(matrix, visited, row, col, 1);
                    sizes.add(len);
                }
            }
        }

        return sizes;
    }

    private static int dfs(int[][] matrix, boolean[][] visited, int row, int col, int len) {
        visited[row][col] = true;

        for (int[] move : getMoves(matrix, row, col)) {
            int futRow = move[0];
            int futCol = move[1];
            if (!visited[futRow][futCol] && matrix[futRow][futCol] == 1) {
                len++;
                len = dfs(matrix, visited, futRow, futCol, len);
            }
        }
        return len;
    }

    private static List<int[]> getMoves(int[][] matrix, int row, int col) {
        List<int[]> moves = new ArrayList<>();
        if (row - 1 >= 0) moves.add(new int[] {row - 1, col});
        if (col - 1 >= 0) moves.add(new int[] {row, col - 1});
        if (row + 1 < matrix.length) moves.add(new int[] {row + 1, col});
        if (col + 1 < matrix[row].length) moves.add(new int[] {row, col + 1});
        return moves;
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
