package graph;

public class RottingOranges1 {

    public static int rottingOranges(int[][] grid) {
        return -1;
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

        System.out.println(rottingOranges(grid3) == -1);
    }
}
