package graph;

import java.util.*;

public class LagestIsland {

    // O(w ^ 2 * h ^ 2) time | O(w * h) space
    public static int largestIsland(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return -1;

        int maxSize = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != 1) {
                    continue;
                }

                maxSize = Math.max(maxSize, dfsSize(matrix, row, col));
            }
        }
        return maxSize;
    }

    private static int dfsSize(int[][] matrix, int startRow, int startCol) {
        int size = 1;

        boolean[][] visited = new boolean[matrix.length][matrix[startRow].length];
        List<int[]> neighbors = getNeighbors(matrix, startRow, startCol);
        Deque<int[]> stack = new LinkedList<>(neighbors);

        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            int row = p[0];
            int col = p[1];

            if (visited[row][col] || matrix[row][col] != 0) {
                continue;
            }
            visited[row][col] = true;
            size++;

            for (int[] np : getNeighbors(matrix, row, col)) {
                stack.push(np);
            }
        }
        return size;
    }

    // O(w * h) time | O(w * h) space
    public static int largestIsland1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return -1;

        int islandNumber = 2;
        List<Integer> islandsSize = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != 0) continue;
                islandsSize.add(dfsSize1(matrix, row, col, islandNumber));
                islandNumber++;
            }
        }

        int maxSize = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != 1) continue;

                Set<Integer> islands = new HashSet<>();
                for (int[] p : getNeighbors(matrix, row, col)) {
                    int currRow = p[0];
                    int currCol = p[1];
                    if (matrix[currRow][currCol] == 1) continue;
                    islands.add(matrix[currRow][currCol]);
                }

                int size = 1;

                for (int island : islands) {
                    size += islandsSize.get(island - 2);
                }
                maxSize = Math.max(size, maxSize);
            }
        }
        return maxSize;
    }

    private static int dfsSize1(int[][] matrix, int startRow, int startCol, int islandNumber) {
        int size = 0;

        Deque<int[]> stack = new LinkedList<>();
        stack.push(new int[] {startRow, startCol});

        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            int row = p[0];
            int col = p[1];

            if (matrix[row][col] != 0) continue;
            matrix[row][col] = islandNumber;
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
                {1, 0, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 0, 1, 0, 0}
        };
        int expected = 8;

        int actual = largestIsland(matrix);
        System.out.println(actual);
        System.out.println(actual == expected);

        actual = largestIsland1(matrix);
        System.out.println(actual);
        System.out.println(actual == expected);
    }
}
