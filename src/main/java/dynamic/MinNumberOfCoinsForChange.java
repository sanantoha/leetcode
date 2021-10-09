package dynamic;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

    // O(n * d) time | O(n) space
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int denom : denoms) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (amount >= denom) {
                    int toCompare = dp[amount - denom];
                    if (toCompare != Integer.MAX_VALUE) {
                        toCompare++;
                    }
                    dp[amount] = Math.min(dp[amount], toCompare);
                }
            }
        }
        return (dp[n] == Integer.MAX_VALUE) ? -1 : dp[n];
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 10};
        System.out.println(minNumberOfCoinsForChange(7, input) == 3);
    }
}
