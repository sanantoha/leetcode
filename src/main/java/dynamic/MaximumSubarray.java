package dynamic;

public class MaximumSubarray {

    // O(n) time | O(1) space
    public static int maxSubArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int v : dp) {
            if (v > max) max = v;
        }

        return max;
    }

    public static int maxSubArray0(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int subArr = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > subArr) subArr = sum;

            if (sum < 0) sum = 0;
        }

        return subArr;
    }

    public static int maxSubArray1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int maxSum = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray0(arr));
        System.out.println(maxSubArray1(arr));

        int[] arr1 = {3, 4, -6, 7, 8, -18, 100};
        System.out.println(maxSubArray(arr1));
        System.out.println(maxSubArray0(arr1));
        System.out.println(maxSubArray1(arr1));

        int[] arr2 = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        System.out.println(maxSubArray(arr2));
        System.out.println(maxSubArray0(arr2));
        System.out.println(maxSubArray1(arr2));
    }
}
