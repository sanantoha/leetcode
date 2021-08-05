package top.interview.question.easy.dynamic;

import java.util.Arrays;

class Solution2 {
    public static int maxSubArray1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] dp = new int[arr.length + 1];
        dp[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int max = 0;
        for (int v : dp) {
            if (v > max) max = v;
        }

        return max;
    }

    public int maxSubArray(int[] nums) {
        int resSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > resSum) {
                resSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return resSum;
    }
}

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(s.maxSubArray(nums));

        int[] nums1 = {-2};

        System.out.println(s.maxSubArray(nums1));

        int[] nums3 = {-2, 1};

        System.out.println(s.maxSubArray(nums3));
    }
}
