package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTraverse1 {

    public static List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;

        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int i = startCol; i <= endCol; i++) {
                result.add(matrix[startRow][i]);
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            endCol--;

            if (startRow <= endRow && startCol <= endCol) {

                for (int i = endCol; i >= startCol; i--) {
                    result.add(matrix[endRow][i]);
                }
                endRow--;

                for (int i = endRow; i >= startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }

        return result;
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
