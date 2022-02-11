package array;

import java.util.Arrays;

public class RotateImage5 {

    // O(w * h) time | O(1) space
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        transpose(matrix);
        reflect(matrix);
    }

    private static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    private static void reflect(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int l = 0;
            int r = matrix[i].length - 1;
            int[] arr = matrix[i];
            while (l < r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
        }
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
