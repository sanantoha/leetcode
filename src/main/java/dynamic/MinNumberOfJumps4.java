package dynamic;

import java.util.Arrays;

/**
 * https://www.algoexpert.io/questions/Min%20Number%20Of%20Jumps
 */
public class MinNumberOfJumps4 {

    // O(n ^ 2) time | O(n) space
    public static int minNumberOfJumps(int[] array) {
        if (array == null || array.length == 0) return 0;

        int[] jumps = new int[array.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] + j >= i && jumps[i] > jumps[j] + 1) {
                    jumps[i] = jumps[j] + 1;
                }
            }
        }

        return jumps[array.length - 1];
    }

    public static int minNumberOfJumps1(int[] array) {
        if (array == null || array.length == 0) return 0;

        int reached = array[0];
        int step = array[0];
        int jump = 0;

        for (int i = 1; i < array.length; i++) {
            reached = Math.max(reached, array[i] + i);
            step--;
            if (step == 0) {
                jump++;
                step = reached - i;
            }
        }
        return jump + 1;
    }

    public static void main(String[] args) {
        int[] input = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        var actual = minNumberOfJumps(input);
        System.out.println(actual);
        System.out.println(actual == 4);

        actual = minNumberOfJumps1(input);
        System.out.println(actual);
        System.out.println(actual == 4);
    }
}
