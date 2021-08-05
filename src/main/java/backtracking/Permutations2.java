package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, 0, result);
        return result;
    }

    private static void backtrack(int[] arr, int idx, List<List<Integer>> result) {
        if (idx == arr.length - 1) {
            result.add(toList(arr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            backtrack(arr, idx + 1, result);
            swap(arr, i, idx);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static List<Integer> toList(int[] arr) {
        List<Integer> result = new ArrayList<>(arr.length);
        for (int v : arr) {
            result.add(v);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};

        System.out.println(permute(arr));
    }
}
