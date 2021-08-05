package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtracking(int[] candidates, int target, int start, List<Integer> answer, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(answer));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            answer.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i, answer, result);
            answer.remove(answer.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7};

        System.out.println(combinationSum(arr, 7));
    }
}
