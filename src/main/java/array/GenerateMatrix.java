package array;

import java.util.Arrays;

public class GenerateMatrix {

    // O(n ^ 2) time | O(n ^ 2) space
    private static int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][];

        int[][] res = new int[n][n];

        int startRow = 0;
        int startCol = 0;
        int endRow = n - 1;
        int endCol = n - 1;

        int idx = 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                res[startRow][i] = idx++;
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                res[i][endCol] = idx++;
            }
            endCol--;

            if (startRow <= endRow && startCol <= endCol) {
                for (int i = endCol; i >= startCol; i--) {
                    res[endRow][i] = idx++;
                }
                endRow--;

                for (int i = endRow; i >= startRow; i--) {
                    res[i][startCol] = idx++;
                }
                startCol++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(generateMatrix(3))); // [[1 2 3] [8 9 4] [7 6 5]]
        System.out.println("============================================");
        System.out.println(Arrays.deepToString(generateMatrix(1))); // [[1]]
        System.out.println("============================================");
        System.out.println(Arrays.deepToString(generateMatrix(4))); // [[1 2 3 4] [12 13 14 5] [11 16 15 6] [10 9 8 7]]
    }
}
