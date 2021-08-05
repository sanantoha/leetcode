package top.interview.question.medium.array_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution1 {

    public void setZeroToMatrix(int[][] matrix, int x, int y) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][y] = 0;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            matrix[x][i] = 0;
        }
    }

    private static final class Tuple {
        private int x;
        private int y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void setZeroes0(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        List<Tuple> lst = new ArrayList<>();

        int i = 0;
        while (i < rowLen) {
            int j = 0;
            while (j < colLen) {
                if (matrix[i][j] == 0) {
                    lst.add(new Tuple(i, j));
                }
                j++;
            }
            i++;
        }

        for (Tuple t : lst) {
            setZeroToMatrix(matrix, t.x, t.y);
        }
    }

    public void setZeroes(int[][] matrix) {

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

public class SetMatrixZeroes {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        int[][] matrix = {{1,1,1},
                          {1,0,1},
                          {1,1,1}};

//        int[][] matrix = {{0, 1}};

        s.setZeroes(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}
