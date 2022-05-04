package array;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/apple/344/array-and-strings/2040/
 */
public class SparseMatrixMultiplication3 {

    public static int[][] multiply(int[][] mat1, int[][] mat2) {
        return null;
    }

    public static int[][] multiply1(int[][] mat1, int[][] mat2) {
        return null;
    }

    public static void main(String[] args) {
//        Input: mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]
//        Output: [[7,0,0],[-7,0,3]]

        int[][] mat1 = {
                {1, 0, 0},
                {-1, 0, 3}
        };
        int[][] mat2 = {
                {7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        System.out.println(Arrays.deepToString(multiply(mat1, mat2)));
        System.out.println();
        System.out.println(Arrays.deepToString(multiply1(mat1, mat2)));
    }
}
