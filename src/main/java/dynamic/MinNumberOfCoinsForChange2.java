package dynamic;

import java.util.Arrays;

public class MinNumberOfCoinsForChange2 {

    // O(d * n) time | O(n) space
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        if (n < 0 || denoms == null || denoms.length == 0) return -1;

        int[] minNumberOfCoins = new int[n + 1];
        Arrays.fill(minNumberOfCoins, Integer.MAX_VALUE);
        minNumberOfCoins[0] = 0;

        for (int denom : denoms) {
            for (int amount = 1; amount <= n; amount++) {
                if (amount >= denom) {
                    int toCompare = minNumberOfCoins[amount - denom];
                    if (toCompare != Integer.MAX_VALUE) {
                        toCompare++;
                    }
                    minNumberOfCoins[amount] = Math.min(minNumberOfCoins[amount], toCompare);
                }
            }
        }
        return minNumberOfCoins[n] == Integer.MAX_VALUE ? -1 : minNumberOfCoins[n];
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 10};
        int actual = minNumberOfCoinsForChange(7, input);
        System.out.println(actual);
        System.out.println(actual == 3);
    }
}
