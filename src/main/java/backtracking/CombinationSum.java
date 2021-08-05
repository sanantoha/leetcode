package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtracking(int[] candidates, int target, int start, List<Integer> answers, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(answers));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            answers.add(candidate);
            backtracking(candidates, target - candidate, i, answers, res);
            answers.remove(answers.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.println(combinationSum(candidates, target));

        int[] coins = {1,2};

        System.out.println(combinationSum(coins, 4));
    }
}
