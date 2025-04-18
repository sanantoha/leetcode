package top.interview.question.easy.dynamic;

class Solution3 {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}

public class HouseRober {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        int[] nums = {4,1,2,7,5,3,1}; // 14

        System.out.println(s.rob(nums));
    }
}
