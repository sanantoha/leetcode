package graph;

import java.util.Arrays;

public class NumberOfIsland {

    private static void dfs(int[][] grid, boolean[][] visited, int currRow, int currCol) {
        visited[currRow][currCol] = true;

        for (int pathRow = -1; pathRow < 2; pathRow++) {
            for (int pathCol = -1; pathCol < 2; pathCol++) {
                if (pathRow == 0 && pathCol == 0) continue;

                int futureRow = currRow + pathRow;
                int futureCol = currCol + pathCol;

                if (futureRow >= 0 && futureRow < grid.length &&
                    futureCol >= 0 && futureCol < grid[0].length &&
                        !visited[futureRow][futureCol] && grid[futureRow][futureCol] == 1) {
//                    visited[futureRow][futureCol] = true;
                    dfs(grid, visited, futureRow, futureCol);
                }
            }
        }
    }

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

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        System.out.println(numberOfIsland(grid));
    }
}
