package top.interview.question.medium.trees;

class Solution6 {
    public int numIslands(char[][] grid) {
        int totalIsland = 0;
        if (grid.length == 0 || grid[0].length == 0) return totalIsland;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (!visited[row][col] && grid[row][col] == '1') {
                    totalIsland++;
                    dfs(grid, visited, row, col);
                }
            }
        }

        return totalIsland;
    }

    public void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        // (-1, 0) (0, -1) (1, 0) (0 1)
        visited[x][y] = true;

        int[][] paths = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int i = 0; i < paths.length; i++) {
            int futX = x + paths[i][0];
            int futY = y + paths[i][1];

            if (futX >= 0 && futX < grid.length &&
                futY >= 0 && futY < grid[0].length &&
                !visited[futX][futY] &&
                grid[futX][futY] == '1') {

                dfs(grid, visited, futX, futY);
            }
        }
    }
}

public class NumberOfIsland {
    public static void main(String[] args) {
        Solution6 s = new Solution6();

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','1','0','0','0'},
                {'0','0','1','1','1'},
        };

        System.out.println(s.numIslands(grid));
    }
}
