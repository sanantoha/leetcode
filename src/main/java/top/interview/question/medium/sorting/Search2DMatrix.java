package top.interview.question.medium.sorting;

class Solution8 {

    public int binarySearch(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else return mid;
        }

        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        for (int[] row : matrix) {
            if (binarySearch(row, target) != -1) return true;
        }
        return false;
    }
}

public class Search2DMatrix {
    public static void main(String[] args) {
        Solution8 s = new Solution8();

        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        System.out.println(s.searchMatrix(matrix, 5));
    }
}