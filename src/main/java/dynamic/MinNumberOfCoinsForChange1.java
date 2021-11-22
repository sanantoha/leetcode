package dynamic;

import java.util.Arrays;

public class MinNumberOfCoinsForChange1 {

    // O(n * d) time | O(n) space
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        if (denoms == null || denoms.length == 0 || n < 0) return 0;

        int[] ways = new int[n + 1];
        Arrays.fill(ways, Integer.MAX_VALUE);
        ways[0] = 0;

        for (int denom : denoms) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (amount >= denom) {
                    int toCompare = ways[amount - denom];
                    if (toCompare != Integer.MAX_VALUE) {
                        toCompare++;
                    }
                    ways[amount] = Math.min(ways[amount], toCompare);
                }
            }
        }

        return ways[n] == Integer.MAX_VALUE ? -1 : ways[n];
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 10};
        int actual = minNumberOfCoinsForChange(7, input);
        System.out.println(actual);
        System.out.println(actual == 3);
    }
}
