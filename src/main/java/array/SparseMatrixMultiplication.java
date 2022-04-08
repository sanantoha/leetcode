package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/explore/interview/card/apple/344/array-and-strings/2040/
 */
public class SparseMatrixMultiplication {

    // O(n ^ 3) time | O(n) space
    public static int[][] multiply(int[][] mat1, int[][] mat2) {
        if (mat1 == null || mat1.length == 0 || mat2 == null || mat2.length == 0) return new int[][] {};
        int[][] res = new int[mat1.length][mat2[0].length];

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                for (int k = 0; k < mat2[j].length; k++) {
                    res[i][j] += mat1[i][j] * mat2[j][k];
                }
            }
        }

        return res;
    }

    // O(m1 * m2 * k) time | O(m1 * k + m2 * k) space
    public static int[][] multiply1(int[][] mat1, int[][] mat2) {
        if (mat1 == null || mat1.length == 0 || mat2 == null || mat2.length == 0) return new int[][] {};
        int[][] res = new int[mat1.length][mat2[0].length];

        List<List<Pair>> m1 = compress(mat1);
        List<List<Pair>> m2 = compress(mat2);

        for (int i = 0; i < mat1.length; i++) {
            for (Pair p1 : m1.get(i)) {
                for (Pair p2 : m2.get(p1.col)) {
                    res[i][p2.col] += p1.val * p2.val;
                }
            }
        }

        return res;
    }

    static class Pair {
        int val;
        int col;

        public Pair(int val, int col) {
            this.val = val;
            this.col = col;
        }
    }

    private static List<List<Pair>> compress(int[][] matrix) {
        List<List<Pair>> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    res.get(i).add(new Pair(matrix[i][j], j));
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
