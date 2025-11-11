package graph;

import java.util.Arrays;

public class ZeroOneMatrix1 {

    public static int[][] updateMatrix(int[][] mat) {
        return null;
    }

    public static void main(String[] args) {

        int[][] input0 = new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };

        /* output:
         * {0, 0, 0},
         * {0, 1, 0},
         * {0, 0, 0},
         */
        int[][] res = updateMatrix(input0);


        System.out.println(Arrays.deepToString(res));

        /* output:
         * {0, 0, 0},
         * {0, 1, 0},
         * {1, 2, 1},
         */
        int[][] input1 = new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };

        res = updateMatrix(input1);

        System.out.println(Arrays.deepToString(res));
    }
}
