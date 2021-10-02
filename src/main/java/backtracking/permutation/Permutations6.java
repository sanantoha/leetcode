package backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations6 {

    // O(n * n!) time | O(n * n!) space
    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(arr, 0, res);
        return res;
    }

    private static void backtrack(int[] arr, int idx, List<List<Integer>> res) {
        if (idx == arr.length) {
            res.add(toList(arr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            backtrack(arr, idx + 1, res);
            swap(arr, i, idx);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static List<Integer> toList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }
}
