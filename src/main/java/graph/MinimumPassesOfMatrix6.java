package graph;

import java.util.*;

/**
 * https://www.algoexpert.io/questions/Minimum%20Passes%20Of%20Matrix
 */
public class MinimumPassesOfMatrix6 {

    // O(w * h) time | O(w * h) space
    public static int minimumPassesOfMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int count = 0;

        Queue<int[]> queue = findAllPositive(matrix);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] p = queue.remove();
                int row = p[0];
                int col = p[1];
                for (int[] np : getNeighbors(matrix, row, col)) {
                    int nrow = np[0];
                    int ncol = np[1];
                    if (matrix[nrow][ncol] < 0) {
                        matrix[nrow][ncol] *= -1;
                        queue.add(new int[] {nrow, ncol});
                    }
                }
            }

            count++;
        }

        return (containsNegative(matrix)) ? -1 : count - 1;
    }

    private static List<int[]> getNeighbors(int[][] matrix, int row, int col) {
        List<int[]> res = new ArrayList<>();

        if (row > 0) res.add(new int[] {row - 1, col});
        if (col > 0) res.add(new int[] {row, col - 1});
        if (row + 1 < matrix.length) res.add(new int[] {row + 1, col});
        if (col + 1 < matrix[row].length) res.add(new int[] {row, col + 1});
        return res;
    }

    private static Queue<int[]> findAllPositive(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) queue.add(new int[] {i, j});
            }
        }
        return queue;
    }

    private static boolean containsNegative(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0, -1, -3, 2, 0}, {1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};
        int expected = 3;
        int actual = minimumPassesOfMatrix(matrix);
        System.out.println(actual);
        System.out.println(expected == actual);
    }
}
