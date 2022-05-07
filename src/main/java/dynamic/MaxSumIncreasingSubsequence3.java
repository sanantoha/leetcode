package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.algoexpert.io/questions/Max%20Sum%20Increasing%20Subsequence
 */
public class MaxSumIncreasingSubsequence3 {

    // O(n ^ 2) time | O(n) space
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        if (array == null || array.length == 0) return Collections.emptyList();

        int[] msi = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            msi[i] = array[i];
        }
        int[] prev = new int[array.length];
        Arrays.fill(prev, -1);

        int maxVal = Integer.MIN_VALUE;
        int maxIdx = 0;

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && msi[i] < msi[j] + array[i]) {
                    msi[i] = msi[j] + array[i];
                    prev[i] = j;
                }
            }
            if (maxVal < msi[i]) {
                maxVal = msi[i];
                maxIdx = i;
            }
        }


        return List.of(List.of(maxVal), buildList(array, prev, maxIdx));
    }

    private static List<Integer> buildList(int[] arr, int[] prev, int maxIdx) {
        List<Integer> res = new ArrayList<>();
        int idx = maxIdx;

        while (idx >= 0) {
            res.add(arr[idx]);
            idx = prev[idx];
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] input = {10, 70, 20, 30, 50, 11, 30};
        int[][] expected = {{110}, {10, 20, 30, 50}};
        List<List<Integer>> actual = maxSumIncreasingSubsequence(input);
        System.out.println(actual);
        System.out.println(compare(actual, expected));
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
