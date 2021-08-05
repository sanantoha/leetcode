package search;

public class Search2DMatrix1 {

    public static boolean searchMatrix(int[][] matrix, int key) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int col = matrix[0].length - 1;
        int row = 0;

        while (row < matrix.length && col >= 0) {

            int curr = matrix[row][col];

            System.out.println(curr);

            if (curr == key) return true;
            else if (curr > key) col--;
            else if (curr < key) row++;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 4, 7, 11, 15},
                { 2, 5, 8, 12, 19},
                { 3, 6, 9, 16, 22},
                {10,13,14, 17, 24},
                {18,21,23, 26, 30}
        };

        System.out.println(searchMatrix(matrix, 21));

        int[][] matrix1 = {
                {1, 4},
                {2, 5}
        };

        System.out.println(searchMatrix(matrix1, 5));
    }
}
