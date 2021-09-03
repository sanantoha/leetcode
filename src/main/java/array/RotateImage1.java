package array;

import java.util.Arrays;

public class RotateImage1 {

    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        transpose(matrix);
        reflect(matrix);
    }

    private static void reflect(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = tmp;
            }
        }
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

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        /*
        1 4 7  => 7 4 1
        2 5 8  => 8 5 2
        3 6 9  => 9 6 3
         */

        rotate(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}
