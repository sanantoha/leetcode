package dynamic;

public class HouseRobber1 {

    // O(n) time | O(n) space
    public static int rob(int[] houses) {
        if (houses == null || houses.length == 0) return 0;

        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < houses.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i]);
        }
        return dp[houses.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,7,5,3,1}; // 14

        System.out.println(rob(nums));
    }
}
