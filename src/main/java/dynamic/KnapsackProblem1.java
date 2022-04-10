package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.algoexpert.io/questions/Knapsack%20Problem
 */
public class KnapsackProblem1 {

    // O(items * capacity) time | O(items * capacity) space
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        if (items == null || items.length == 0) return Collections.emptyList();

        int[][] knapsack = new int[items.length + 1][capacity + 1];

        for (int i = 1; i <= items.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int[] item = items[i - 1];
                int v = item[0];
                int w = item[1];
                if (w > c) {
                    knapsack[i][c] = knapsack[i - 1][c];
                } else {
                    knapsack[i][c] = Math.max(knapsack[i - 1][c - w] + v, knapsack[i - 1][c]);
                }
            }
        }

        return Arrays.asList(List.of(knapsack[items.length][capacity]), buildSequence(knapsack, items));
    }

    private static List<Integer> buildSequence(int[][] knapsack, int[][] items) {
        int i = knapsack.length - 1;
        int c = knapsack[i].length - 1;

        List<Integer> res = new ArrayList<>();

        while (i > 0) {
            if (knapsack[i][c] == knapsack[i - 1][c]) {
                i--;
            } else {
                res.add(i - 1);
                c -= items[i - 1][1];
                i -= 1;
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        int[][] expected = {{10}, {1, 3}};
        System.out.println(compare(knapsackProblem(input, 10), expected));
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
