package dynamic;

import java.util.Arrays;

public class MinNumberOfCoinsForChange4 {

    // O(n * d) time | O(n) space
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        if (n < 0 || denoms == null || denoms.length == 0) return -1;

        int[] minCoins = new int[n + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;

        for (int denom : denoms) {
            for (int amount = 1; amount <= n; amount++) {
                if (amount >= denom) {
                    int toCompare = minCoins[amount - denom];
                    if (toCompare != Integer.MAX_VALUE) {
                        toCompare++;
                    }
                    minCoins[amount] = Math.min(minCoins[amount], toCompare);
                }
            }
        }

        return minCoins[n] == Integer.MAX_VALUE ? -1 : minCoins[n];
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 10};
        int actual = minNumberOfCoinsForChange(7, input);
        System.out.println(actual);
        System.out.println(actual == 3);
    }
}
