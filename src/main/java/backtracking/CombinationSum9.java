package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum9 {

    // O(N ^ (M / T + 1)) time | O(T / M) space
    // where N is the number of candidates, M is the smallest candidate among all the given integers,
    // and T is the target value.
    // Thus the time complexity is exponential and this is expected because the algorithm is
    // recursive backtracking.
    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(arr, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private static void backtrack(int[] arr, int target, int idx, List<Integer> subRes, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            subRes.add(arr[i]);
            backtrack(arr, target - arr[i], i, subRes, res);
            subRes.remove(subRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7};

        System.out.println(combinationSum(arr, 7)); // [[2, 2, 3], [2, 5], [7]]
    }
}
