package backtracking;

/**
 * https://leetcode.com/problems/unique-paths-iii/description/
 *
 * You are given an m x n integer array grid where grid[i][j] could be:
 *
 * 1 representing the starting square. There is exactly one starting square.
 * 2 representing the ending square. There is exactly one ending square.
 * 0 representing empty squares we can walk over.
 * -1 representing obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square,
 * that walk over every non-obstacle square exactly once.
 *
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 */
public class UniquePathIII {

    // O(3 ^ n) time | O(n) space
    private static int uniquePath3(int[][] grid) {
        int startRow = 0;
        int startCol = 0;
        int zeros = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) zeros++;
                else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        return path(grid, startRow, startCol, zeros);
    }

    private static int path(int[][] grid, int row, int col, int zeros) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == -1) {
            return 0;
        }

        if (grid[row][col] == 2) {
            return (zeros == -1) ? 1 : 0;
        }

        grid[row][col] = -1;
        zeros--;

        int totalCount = path(grid, row - 1, col, zeros) + path(grid, row, col - 1, zeros) +
                path(grid, row + 1, col, zeros) + path(grid, row, col + 1, zeros);

        grid[row][col] = 0;
        zeros++;
        return totalCount;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
            };

        int actual = uniquePath3(grid);
        System.out.println(actual);
        System.out.println(actual == 2);
    }
}
