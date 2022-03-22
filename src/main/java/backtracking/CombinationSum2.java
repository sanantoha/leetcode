package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {

    // O(N ^ (M / T - 1)) time | O(T / M) space -
    // where N number of candidates, T is the target value, M - the smallest candidate among all given integers
    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(arr, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] arr, int target, int idx, List<Integer> ans, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            int num = arr[i];
            ans.add(num);
            backtrack(arr, target - num, i, ans, res);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7};

        System.out.println(combinationSum(arr, 7)); // [[2, 2, 3], [2, 5], [7]]
    }
}
