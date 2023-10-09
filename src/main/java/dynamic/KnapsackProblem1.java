package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.algoexpert.io/questions/Knapsack%20Problem
 */
public class KnapsackProblem1 {

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {

        List<Integer> totalValue = Arrays.asList(10);
        List<Integer> finalItems = Arrays.asList(1, 2);
        var result = new ArrayList<List<Integer>>();
        result.add(totalValue);
        result.add(finalItems);
        return result;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2}, {4, 3}, {5, 6}, {6, 7}}; // 0 - value, 1 - weight
        int[][] expected = {{10}, {1, 3}};
        List<List<Integer>> res = knapsackProblem(input, 10);
        System.out.println(res);
        System.out.println(compare(res, expected));
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
