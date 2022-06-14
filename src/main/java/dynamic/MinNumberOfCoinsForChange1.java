package dynamic;

import java.util.Arrays;

public class MinNumberOfCoinsForChange1 {

    // O(n * d) time | O(n) space
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        if (n < 0 || denoms == null || denoms.length == 0) return 0;

        int[] minNums = new int[n + 1];
        Arrays.fill(minNums, Integer.MAX_VALUE);
        minNums[0] = 0;

        for (int denom : denoms) {
            for (int amount = 1; amount <= n; amount++) {
                if (amount >= denom) {
                    int toChange = minNums[amount - denom];
                    if (toChange != Integer.MAX_VALUE) {
                        toChange++;
                    }
                    minNums[amount] = Math.min(minNums[amount], toChange);
                }
            }
        }
        return minNums[n];
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 10};
        int actual = minNumberOfCoinsForChange(7, input);
        System.out.println(actual);
        System.out.println(actual == 3);
    }
}
