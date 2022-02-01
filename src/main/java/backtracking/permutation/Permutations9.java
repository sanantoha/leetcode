package backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations9 {

    // O(n * n!) time | O(n * n!) space
    private static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(arr, 0, res);
        return res;
    }

    private static void backtrack(int[] arr, int idx, List<List<Integer>> res) {
        if (arr.length == idx) {
            res.add(toList(arr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            backtrack(arr, idx + 1, res);
            swap(arr, idx, i);
        }
    }

    private static List<Integer> toList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }
}
