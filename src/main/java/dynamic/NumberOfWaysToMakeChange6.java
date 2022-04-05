package dynamic;

/**
 * https://www.algoexpert.io/questions/Number%20Of%20Ways%20To%20Make%20Change
 * 2 // 1x1  + 1x5 and 6x1
 */
public class NumberOfWaysToMakeChange6 {

    // O(d * n) time | O(n) space
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        if (denoms == null || denoms.length == 0 || n < 0) return -1;

        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int denom : denoms) {
            for (int amout = 1; amout <= n; amout++) {
                if (amout >= denom) {
                    ways[amout] += ways[amout - denom];
                }
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        int[] input = {1, 5};
        int actual = numberOfWaysToMakeChange(6, input);
        System.out.println(actual);
        System.out.println(actual == 2);
    }
}
