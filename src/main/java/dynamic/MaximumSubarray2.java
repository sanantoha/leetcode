package dynamic;

public class MaximumSubarray2 {

    public static int maximumSubarray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : arr) {
            sum += num;
            if (sum > maxSum) maxSum = sum;
            if (sum < 0) sum = 0;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4}; // 19
        System.out.println(maximumSubarray(arr));

        int[] arr1 = {-2,1,-3,4,-1,2,1,-5,4}; // 6

        System.out.println(maximumSubarray(arr1));

        int[] arr2 = {3, 4, -6, 7, 8, -18, 100}; // 100
        System.out.println(maximumSubarray(arr2));
    }
}
