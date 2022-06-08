package array;

import java.util.List;

public class SpiralMatrixTraverse1 {

    public static List<Integer> spiral(int[][] matrix) {
        return null;
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
