package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.algoexpert.io/questions/Knapsack%20Problem
 */
public class KnapsackProblem {

    // O(n * c) time | O(n * c) space
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        if (items == null || items.length == 0) return Collections.emptyList();

        int[][] knapsackValues = new int[items.length + 1][capacity + 1];

        for (int i = 1; i < items.length + 1; i++) {
            for (int c = 1; c < capacity + 1; c++) {
                int weight = items[i - 1][1];
                int val = items[i - 1][0];
                if (weight > c) {
                    knapsackValues[i][c] = knapsackValues[i - 1][c];
                } else {
                    knapsackValues[i][c] = Math.max(
                            knapsackValues[i - 1][c - weight] + val,
                            knapsackValues[i - 1][c]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(knapsackValues));
        List<Integer> totalValue = Arrays.asList(knapsackValues[items.length][capacity]);
        List<Integer> finalItems = getFinalItems(items, knapsackValues);
        var result = new ArrayList<List<Integer>>();
        result.add(totalValue);
        result.add(finalItems);
        return result;
    }

    private static List<Integer> getFinalItems(int[][] items, int[][] knapsackValues) {
        List<Integer> res = new ArrayList<>();

        int i = knapsackValues.length - 1;
        int c = knapsackValues[0].length - 1;

        while (i > 0) {
            if (knapsackValues[i - 1][c] == knapsackValues[i][c]) {
                i--;
            } else {
                res.add(i - 1);
                c -= items[i - 1][1];
                i--;
            }
            if (c == 0) break;
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        int[][] expected = {{10}, {1, 3}};
        List<List<Integer>> actual = knapsackProblem(input, 10);
        System.out.println(actual);
        System.out.println(compare(actual, expected));
    }

    private static boolean compare(List<List<Integer>> arr1, int[][] arr2) {
        if (arr1.get(0).get(0) != arr2[0][0]) {
            return false;
        }
        if (arr1.get(1).size() != arr2[1].length) {
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
