package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum4 {

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] arr, int target, int start, List<Integer> ans, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            ans.add(arr[i]);
            backtrack(arr, target - arr[i], i, ans, result);
            ans.remove(ans.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7};

        System.out.println(combinationSum(arr, 7)); // [[2, 2, 3], [2, 5], [7]]
    }
}
