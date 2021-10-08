package dynamic;

/**
 * https://www.algoexpert.io/questions/Number%20Of%20Ways%20To%20Make%20Change
 * 2 // 1x1  + 1x5 and 6x1
 */
public class NumberOfWaysToMakeChange {

    // O(n * d) time | O(n) space - where d length of denoms
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        if (n < 0 || denoms == null || denoms.length == 0) return 0;

        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int denom : denoms) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (denom <= amount) {
                    ways[amount] += ways[amount - denom];
                }
            }
        }

        return ways[n];
    }

    public static void main(String[] args) {
        int[] input = {1, 5};
        System.out.println(numberOfWaysToMakeChange(6, input) == 2);
    }
}
