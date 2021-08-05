package top.interview.question.medium.dynamic;

class Solution3 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int maxV = 0;
        for (int value : dp) {
            if (value > maxV) maxV = value;
        }
        return maxV;
    }
}

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        int[] arr = {10,9,2,5,3,7,101,18};

        System.out.println(s.lengthOfLIS(arr));
    }
}
