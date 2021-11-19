package dynamic;

/**
 * https://www.algoexpert.io/questions/Number%20Of%20Ways%20To%20Make%20Change
 * 2 // 1x1  + 1x5 and 6x1
 */
public class NumberOfWaysToMakeChange3 {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {1, 5};
        int actual = numberOfWaysToMakeChange(6, input);
        System.out.println(actual);
        System.out.println(actual == 2);
    }
}
