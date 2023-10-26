package graph;

public class NumberOfIsland1 {

    private static int numberOfIsland(int[][] grid) {
        return -1;
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
