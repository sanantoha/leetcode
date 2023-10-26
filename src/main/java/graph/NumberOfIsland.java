package graph;

import java.util.*;

public class NumberOfIsland {

    // O(w * h) time | O(w * h) space
    public static int numberOfIsland(int[][] grid) {
        int totalIsland = 0;

        if (grid.length == 0 || grid[0].length == 0) return totalIsland;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == 1 && !visited[row][col]) {
                    totalIsland++;
                    dfs(grid, visited, row, col);
                }
            }
        }

        return totalIsland;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int startRow, int startCol) {

        Deque<int[]> stack = new LinkedList<>();
        stack.push(new int[] {startRow, startCol});

        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            int row = p[0];
            int col = p[1];

            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;

            for (int[] np : getNeighbors(grid, row, col)) {
                int nrow = np[0];
                int ncol = np[1];
                if (grid[nrow][ncol] != 1) {
                    continue;
                }
                stack.push(new int[] {nrow, ncol});
            }
        }
    }

    private static List<int[]> getNeighbors(int[][] grid, int row, int col) {
        List<int[]> neighbors = new ArrayList<>();

        if (row > 0) {
            neighbors.add(new int[] {row - 1, col});
        }
        if (col > 0) {
            neighbors.add(new int[] {row, col - 1});
        }
        if (row + 1 < grid.length) {
            neighbors.add(new int[] {row + 1, col});
        }
        if (col + 1 < grid[row].length) {
            neighbors.add(new int[] {row, col + 1});
        }

        return neighbors;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        int expected = 3;

        int actual = numberOfIsland(grid);
        System.out.println(actual);
        System.out.println(actual == expected);
    }
}
