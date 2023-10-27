package graph;

import java.util.*;


public class RiverSizes {

    // O(w * h) time | O(w * h) space
    public static List<Integer> riverSizes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col] && matrix[row][col] == 1) {
                    res.add(dfsSize(matrix, visited, row, col));
                }
            }
        }

        return res;
    }

    private static int dfsSize(int[][] matrix, boolean[][] visited, int startRow, int startCol) {
        int size = 0;

        Deque<int[]> stack = new LinkedList<>();
        stack.push(new int[] {startRow, startCol});

        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            int row = p[0];
            int col = p[1];

            if (visited[row][col] || matrix[row][col] != 1) continue;
            visited[row][col] = true;
            size++;

            for (int[] np : getNeighbors(matrix, row, col)) {
                stack.push(np);
            }
        }

        return size;
    }

    private static List<int[]> getNeighbors(int[][] matrix, int row, int col) {
        List<int[]> res = new ArrayList<>();

        if (row > 0) {
            res.add(new int[] {row - 1, col});
        }
        if (col > 0) {
            res.add(new int[] {row, col - 1});
        }
        if (row + 1 < matrix.length) {
            res.add(new int[] {row + 1, col});
        }
        if (col + 1 < matrix[row].length) {
            res.add(new int[] {row, col + 1});
        }

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

        System.out.println(riverSizes(matrix)); // [2, 1, 5, 2, 2]
    }
}
