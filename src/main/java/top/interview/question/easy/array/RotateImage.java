package top.interview.question.easy.array;

import java.util.Arrays;

class Solution10 {
    public void rotate(int[][] matrix) {

        int[][] m = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int nj = matrix[i].length - i - 1;
                m[j][nj] = matrix[i][j];
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                matrix[i][j] = m[i][j];
            }
        }
    }
}

public class RotateImage {
    public static void main(String[] args) {
        Solution10 s = new Solution10();

        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        s.rotate(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}
