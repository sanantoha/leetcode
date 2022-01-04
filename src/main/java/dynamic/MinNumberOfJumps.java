package dynamic;

import java.util.Arrays;

/**
 * https://www.algoexpert.io/questions/Min%20Number%20Of%20Jumps
 */
public class MinNumberOfJumps {

    // O(n ^ 2) time | O(n) space
    public static int minNumberOfJumps(int[] array) {
        if (array == null || array.length == 0) return 0;

        int[] minJumps = new int[array.length];
        Arrays.fill(minJumps, Integer.MAX_VALUE);
        minJumps[0] = 0;

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] + j >= i && minJumps[i] > minJumps[j] + 1) {
                    minJumps[i] = minJumps[j] + 1;
                }
            }
        }

        return minJumps[minJumps.length - 1];
    }

    // O(n) time | O(1) space
    public static int minNumberOfJumps1(int[] array) {
        if (array == null || array.length <= 1) return 0;

        int maxReach = array[0];
        int steps = array[0];
        int jumps = 0;

        for (int i = 1; i < array.length - 1; i++) {
            maxReach = Math.max(maxReach, array[i] + i);
            steps--;
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }
        return jumps + 1;
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
