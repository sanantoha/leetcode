package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.algoexpert.io/questions/Minimum%20Passes%20Of%20Matrix
 */
public class MinimumPassesOfMatrix5 {

    // O(w * h) time | O(w * h) space
    public static int minimumPassesOfMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return -1;

        Queue<int[]> queue = findAllPositives(matrix);

        int minPasses = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] xy = queue.remove();
                int x = xy[0];
                int y = xy[1];

                for (int[] neighbor : getNeighbors(matrix, x, y)) {
                    int nx = neighbor[0];
                    int ny = neighbor[1];
                    if (matrix[nx][ny] < 0) {
                        matrix[nx][ny] *= -1;
                        queue.add(neighbor);
                    }
                }
            }

            minPasses++;
        }

        return containsNegative(matrix) ? - 1 : minPasses - 1;
    }

    private static boolean containsNegative(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) return true;
            }
        }
        return false;
    }

    private static List<int[]> getNeighbors(int[][] matrix, int x, int y) {
        List<int[]> neighbors = new ArrayList<>();
        if (x > 0) neighbors.add(new int[] {x - 1, y});
        if (y > 0) neighbors.add(new int[] {x, y - 1});
        if (x + 1 < matrix.length) neighbors.add(new int[] {x + 1, y});
        if (y + 1 < matrix[x].length) neighbors.add(new int[] {x, y + 1});
        return neighbors;
    }

    private static Queue<int[]> findAllPositives(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    queue.add(new int[] {i, j});
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
