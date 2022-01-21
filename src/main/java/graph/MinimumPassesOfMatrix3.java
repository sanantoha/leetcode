package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.algoexpert.io/questions/Minimum%20Passes%20Of%20Matrix
 */
public class MinimumPassesOfMatrix3 {

    // O(w * h) time | O(w * h) space
    public static int minimumPassesOfMatrix(int[][] matrix) {
        int minPasses = 0;
        if (matrix == null || matrix.length == 0) return minPasses;

        Queue<int[]> queue = findAllPositiveValue(matrix);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] p = queue.remove();
                int x = p[0];
                int y = p[1];

                List<int[]> neighbors = getNeighbors(matrix, x, y);
                for (int[] neighbor : neighbors) {
                    int nx = neighbor[0];
                    int ny = neighbor[1];
                    if (matrix[nx][ny] < 0) {
                        queue.add(new int[] {nx, ny});
                        matrix[nx][ny] *= -1;
                    }
                }
            }

            minPasses++;
        }
        return isContainNegative(matrix) ? -1 : minPasses - 1;
    }

    private static boolean isContainNegative(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) return true;
            }
        }
        return false;
    }

    private static List<int[]> getNeighbors(int[][] matrix, int row, int col) {
        List<int[]> neighbors = new ArrayList<>();

        if (row > 0) neighbors.add(new int[] {row - 1, col});
        if (col > 0) neighbors.add(new int[] {row, col - 1});
        if (row + 1 < matrix.length) neighbors.add(new int[] {row + 1, col});
        if (col + 1 < matrix[row].length) neighbors.add(new int[] {row, col + 1});

        return neighbors;
    }

    private static Queue<int[]> findAllPositiveValue(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) queue.add(new int[] {i, j});
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0, -1, -3, 2, 0}, {1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};
        int expected = 3;
        int actual = minimumPassesOfMatrix(matrix);
        System.out.println(actual);
        System.out.println(expected == actual);
    }
}
