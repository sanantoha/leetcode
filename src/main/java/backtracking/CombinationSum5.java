package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum5 {

    public static List<List<Integer>> combinationSum(int[] coins, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(coins, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] coins, int target, int idx, List<Integer> ans, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = idx; i < coins.length; i++) {
            ans.add(coins[i]);
            backtrack(coins, target - coins[i], i, ans, res);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7};

        System.out.println(combinationSum(arr, 7)); // [[2, 2, 3], [2, 5], [7]]
    }
}
