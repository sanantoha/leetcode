package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtracking(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    private static void backtracking(int[] candidates, int start, int target, List<Integer> answers, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(answers));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            answers.add(candidates[i]);
            backtracking(candidates, i, target - candidates[i], answers, result);
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
