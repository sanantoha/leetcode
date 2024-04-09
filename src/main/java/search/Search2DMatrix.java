package search;

public class Search2DMatrix {

    // O(w + h) time | O(1) space
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {

            int curr = matrix[row][col];

            if (curr == target) return true;
            else if (curr > target) col--;
            else if (curr < target) row++;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        System.out.println(searchMatrix(matrix, 16));

        int[][] matrix1 = {
                {1, 4},
                {2, 5}
        };

        System.out.println(searchMatrix(matrix1, 2));
    }
}
