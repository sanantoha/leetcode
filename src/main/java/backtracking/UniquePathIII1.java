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
public class UniquePathIII1 {

    private static int uniquePath3(int[][] grid) {
        return -1;
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
