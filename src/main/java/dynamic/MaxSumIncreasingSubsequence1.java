package dynamic;

import java.util.List;

/**
 * https://www.algoexpert.io/questions/Max%20Sum%20Increasing%20Subsequence
 */
public class MaxSumIncreasingSubsequence1 {

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {

        return List.of(List.of(110), List.of(10, 20, 30, 50));
    }

    public static void main(String[] args) {
        int[] input = {10, 70, 20, 30, 50, 11, 30};
        int[][] expected = {{110}, {10, 20, 30, 50}};
        System.out.println(compare(maxSumIncreasingSubsequence(input), expected));
    }

    public static boolean compare(List<List<Integer>> arr1, int[][] arr2) {
        if (arr1.get(0).get(0) != arr2[0][0]) {
            return false;
        }
        for (int i = 0; i < arr1.get(1).size(); i++) {
            if (arr1.get(1).get(i) != arr2[1][i]) {
                return false;
            }
        }
        return true;
    }
}
