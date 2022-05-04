package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/explore/interview/card/apple/344/array-and-strings/2040/
 */
public class SparseMatrixMultiplication1 {

    // O(n * k * n) time | O(1) space
    public static int[][] multiply(int[][] mat1, int[][] mat2) {
        if (mat1[0].length != mat2.length) return new int[][] {};

        int[][] res = new int[mat1.length][mat2[0].length];

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                for (int k = 0; k < mat2[j].length; k++) {
                    res[i][k] += mat1[i][j] * mat2[j][k];
                }
            }
        }

        return res;
    }

    // O(n * k * m) time | O(n * k + k * m) space
    public static int[][] multiply1(int[][] mat1, int[][] mat2) {
        if (mat1[0].length != mat2.length) return new int[][] {};

        int[][] res = new int[mat1.length][mat2[0].length];

        List<List<int[]>> m1 = compress(mat1);
        List<List<int[]>> m2 = compress(mat2);

        for (int m1Row = 0; m1Row < mat1.length; m1Row++) {
            for (int[] m1Cell : m1.get(m1Row)) {
                for (int[] m2Cell : m2.get(m1Cell[1])) {
                    res[m1Row][m2Cell[1]] += m1Cell[0] * m2Cell[0];
                }
            }
        }

        return res;
    }

    private static List<List<int[]>> compress(int[][] mat) {
        List<List<int[]>> res = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    res.get(i).add(new int[] {mat[i][j], j});
                }
            }
        }

        return res;
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
