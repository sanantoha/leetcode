package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.algoexpert.io/questions/Minimum%20Passes%20Of%20Matrix
 */
public class MinimumPassesOfMatrix1 {

    // O(w * h) time | O(w * h) space
    public static int minimumPassesOfMatrix(int[][] matrix) {
        int minPasses = 0;
        if (matrix == null || matrix.length == 0) return minPasses;

        Queue<int[]> queue = findPositives(matrix);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] pair = queue.remove();
                int row = pair[0];
                int col = pair[1];
                List<int[]> neighbors = getNeighbors(matrix, row, col);
                for (int[] neighbor : neighbors) {
                    int nRow = neighbor[0];
                    int nCol = neighbor[1];
                    if (matrix[nRow][nCol] < 0) {
                        queue.add(new int[] {nRow, nCol});
                        matrix[nRow][nCol] *= -1;
                    }
                }
            }

            minPasses++;
        }

        return isContainNegative(matrix) ? -1 : minPasses - 1;
    }

    private static boolean isContainNegative(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] < 0) return true;
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

    private static Queue<int[]> findPositives(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] > 0) {
                    queue.add(new int[] {row, col});
                }
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
