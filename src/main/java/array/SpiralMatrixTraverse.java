package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTraverse {

    public static List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int rowStart = 0;
        int rowEnd = matrix.length;
        int colStart = 0;
        int colEnd = matrix[0].length;

        while (rowStart < rowEnd && colStart < colEnd) {

            for (int i = colStart; i < colEnd; i++) {
                res.add(matrix[rowStart][i]);
            }
            rowStart++;

            for (int i = rowStart; i < rowEnd; i++) {
                res.add(matrix[i][colEnd - 1]);
            }
            colEnd--;

            if (rowStart < rowEnd && colStart < colEnd) {
                for (int i = colEnd - 1; i >= colStart; i--) {
                    res.add(matrix[rowEnd - 1][i]);
                }
                rowEnd--;

                for (int i = rowEnd - 1; i >= rowStart; i--) {
                    res.add(matrix[i][colStart]);
                }
                colStart++;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  2,  3,  5,  6,  7},
                {19, 20, 21, 22, 23,  8},
                {18, 29, 30, 31, 24,  9},
                {17, 28, 27, 26, 25, 10},
                {16, 15, 14, 13, 12, 11}
        };

        System.out.println(spiral(matrix));
    }
}
