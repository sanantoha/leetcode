package dynamic;

import java.util.Arrays;

public class MinNumberOfCoinsForChange3 {

    // O(d * n) time | O(n) space
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        if (n < 0 || denoms == null || denoms.length == 0) return 0;

        int[] minNumbers = new int[n + 1];
        Arrays.fill(minNumbers, Integer.MAX_VALUE);
        minNumbers[0] = 0;

        for (int denom : denoms) {
            for (int amount = 0; amount <= n; amount++) {
                if (amount >= denom) {
                    int toCompare = minNumbers[amount - denom];
                    if (toCompare != Integer.MAX_VALUE) {
                        toCompare++;
                    }
                    minNumbers[amount] = Math.min(toCompare, minNumbers[amount]);
                }
            }
        }
        return minNumbers[n] == Integer.MAX_VALUE ? -1 : minNumbers[n];
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 10};
        int actual = minNumberOfCoinsForChange(7, input);
        System.out.println(actual);
        System.out.println(actual == 3);
    }
}
