package array;

import java.util.Arrays;

public class RotateImage7 {

    public static void rotate(int[][] matrix) {

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        /*
    1 2 3  =>  1 4 7  => 7 4 1
    4 5 6  =>  2 5 8  => 8 5 2
    7 8 9  =>  3 6 9  => 9 6 3
         */

        rotate(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}
