package dynamic;

import java.util.Arrays;

public class MinNumberOfCoinsForChange5 {

    // O(n * d) time | O(n) space
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        if (n <= 0 || denoms == null || denoms.length == 0) return 0;

        int[] ways = new int[n + 1];
        Arrays.fill(ways, Integer.MAX_VALUE);
        ways[0] = 0;

        for (int denom : denoms) {
            for (int amount = 1; amount <= n; amount++) {
                if (amount >= denom) {
                    int toChange = ways[amount - denom];
                    if (toChange != Integer.MAX_VALUE) {
                        toChange++;
                    }
                    ways[amount] = Math.min(ways[amount], toChange);
                }
            }
        }
        return ways[n] == Integer.MAX_VALUE ? - 1 : ways[n];
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 10};
        int actual = minNumberOfCoinsForChange(7, input);
        System.out.println(actual);
        System.out.println(actual == 3);
    }
}
