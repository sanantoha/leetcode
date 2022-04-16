package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/explore/interview/card/apple/344/array-and-strings/2040/
 */
public class SparseMatrixMultiplication2 {

    // O(m * k * m) time | O(1) space
    public static int[][] multiply(int[][] mat1, int[][] mat2) {
        if (mat1 == null || mat1.length == 0 || mat2 == null || mat2.length == 0) {
            return new int[][] {};
        }
        if (mat1[0].length != mat2.length) return new int[][]{};

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

    // O(m * k * n) time | O(m * k + n * k) space
    public static int[][] multiply1(int[][] mat1, int[][] mat2) {
        if (mat1 == null || mat1.length == 0 || mat2 == null || mat2.length == 0) {
            return new int[][] {};
        }
        if (mat1[0].length != mat2.length) return new int[][]{};


        List<List<int[]>> m1 = compressMatrix(mat1);
        List<List<int[]>> m2 = compressMatrix(mat2);

        int[][] res = new int[mat1.length][mat2[0].length];

        for (int m1Row = 0; m1Row < mat1.length; m1Row++) {
            for (int[] m1ValCol : m1.get(m1Row)) {
                for (int[] m2ValCol : m2.get(m1ValCol[1])) {
                    res[m1Row][m2ValCol[1]] += m1ValCol[0] * m2ValCol[0];
                }
            }
        }
        return res;
    }

    private static List<List<int[]>> compressMatrix(int[][] mat) {
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
