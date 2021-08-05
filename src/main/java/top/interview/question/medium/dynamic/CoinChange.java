package top.interview.question.medium.dynamic;

import java.util.Arrays;

class Solution2 {


    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}

public class CoinChange {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        int[] coins = {5};

        System.out.println(s.coinChange(coins, 4));
    }
}
