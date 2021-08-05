package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Program {

    public static List<Integer> riverSizes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int len = dfs(matrix, visited, i, j, 1);
                    result.add(len);
                }
            }
        }

        return result;
    }

    private static int dfs(int[][] matrix, boolean[][] visited, int currX, int currY, int len) {
        visited[currX][currY] = true;

        int[][] path = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

        for (int i = 0; i < path.length; i++) {
            int futX = currX + path[i][0];
            int futY = currY + path[i][1];

            if (futX >= 0 && futX < matrix.length &&
                futY >= 0 && futY < matrix[0].length &&
                !visited[futX][futY] &&
                matrix[futX][futY] == 1) {
                len++;
                len = dfs(matrix, visited, futX, futY, len);
            }
        }
        return len;
    }
}

public class RiverSizes {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 0, 1, 0},
            {1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0}
        };

        System.out.println(Program.riverSizes(matrix));
    }
}
