package graph;

import java.util.*;

public class ZeroOneMatrix {

    // O(w * h) time | O(w * h) space
    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        replaceOneOnMaxVal(matrix);

        Queue<int[]> queue = findAllZeros(matrix);

        while (!queue.isEmpty()) {
            int[] t = queue.remove();
            int row = t[0];
            int col = t[1];
            int level = t[2];

            for (int[] p : getNeighborns(matrix, row, col)) {
                int nrow = p[0];
                int ncol = p[1];
                if (matrix[nrow][ncol] == Integer.MAX_VALUE) {
                    queue.add(new int[] {nrow, ncol, level + 1});
                }
                matrix[nrow][ncol] = Math.min(level + 1, matrix[nrow][ncol]);
            }
        }

        return matrix;
    }

    private static List<int[]> getNeighborns(int[][] matrix, int row, int col) {
        List<int[]> res = new ArrayList<>();
        if (row > 0) {
            res.add(new int[]{row - 1, col});
        }
        if (col > 0) {
            res.add(new int[]{row, col - 1});
        }
        if (row + 1 < matrix.length) {
            res.add(new int[]{row + 1, col});
        }
        if (col + 1 < matrix[row].length) {
            res.add(new int[]{row, col + 1});
        }
        return res;
    }

    private static Queue<int[]> findAllZeros(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    queue.add(new int[]{row, col, 0});
                }
            }
        }
        return queue;
    }

    private static void replaceOneOnMaxVal(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    matrix[row][col] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] input0 = new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };

        /* output:
         * {0, 0, 0},
         * {0, 1, 0},
         * {0, 0, 0},
         */
        int[][] res = updateMatrix(input0);


        System.out.println(Arrays.deepToString(res));

        /* output:
         * {0, 0, 0},
         * {0, 1, 0},
         * {1, 2, 1},
         */
        int[][] input1 = new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };

        res = updateMatrix(input1);

        System.out.println(Arrays.deepToString(res));
    }
}
