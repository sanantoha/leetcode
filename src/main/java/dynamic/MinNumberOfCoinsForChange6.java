package dynamic;

import java.util.Arrays;

public class MinNumberOfCoinsForChange6 {

    // O(d * n) time | O(n) space
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        if (denoms == null || denoms.length == 0 || n < 0) return 0;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int denom : denoms) {
            for (int amount = 1; amount <= n; amount++) {
                if (amount >= denom) {
                    int toChange = dp[amount - denom];
                    if (toChange != Integer.MAX_VALUE) toChange++;
                    dp[amount] = Math.min(dp[amount], toChange);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 10};
        int actual = minNumberOfCoinsForChange(7, input);
        System.out.println(actual);
        System.out.println(actual == 3);
    }
}
