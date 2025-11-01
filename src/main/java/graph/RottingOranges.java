package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    // O(w * h) time | O(w * h) space
    public static int rottingOranges(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        Queue<int[]> queue = findAllRotten(grid);
        if (queue.isEmpty()) {
            if (isAtLeastOneFresh(grid)) {
                return -1;
            } else {
                return 0;
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            count++;

            while (size-- > 0) {
                int[] p = queue.remove();
                int row = p[0];
                int col = p[1];

                for (int[] np : getNeighbors(grid, row, col)) {
                    int nrow = np[0];
                    int ncol = np[1];
                    if (grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        queue.add(new int[]{nrow, ncol});
                    }
                }
            }
        }

        if (isAtLeastOneFresh(grid)) {
            return -1;
        } else {
            return count - 1;
        }
    }

    private static boolean isAtLeastOneFresh(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Queue<int[]> findAllRotten(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[]{row, col});
                }
            }
        }
        return queue;
    }

    private static List<int[]> getNeighbors(int[][] grid, int row, int col) {
        List<int[]> res = new ArrayList<>();

        if (row > 0) {
            res.add(new int[]{row - 1, col});
        }
        if (col > 0) {
            res.add(new int[]{row, col - 1});
        }
        if (row + 1 < grid.length) {
            res.add(new int[]{row + 1, col});
        }
        if (col + 1 < grid[row].length) {
            res.add(new int[]{row, col + 1});
        }
        return res;
    }


    /**
     * 0 - nothing
     * 1 - fresh
     * 2 - rotten
     * @param args
     */
    public static void main(String[] args) {

        int[][] grid0 = new int[][] {
            {2,1,1},
            {1,1,0},
            {0,1,1},
        };

        System.out.println(rottingOranges(grid0) == 4);


        int[][] grid1 = new int[][] {
                {2,1,1},
                {0,1,1},
                {1,0,1},
        };

        System.out.println(rottingOranges(grid1) == -1);

        int[][] grid2 = new int[][] {
                {0, 2},
        };

        System.out.println(rottingOranges(grid2) == 0);

        int[][] grid3 = new int[][] {
                {0},
        };

        System.out.println(rottingOranges(grid3) == 0);

        int[][] grid4 = new int[][] {
                {1},
        };

        System.out.println(rottingOranges(grid4) == -1);
    }
}
