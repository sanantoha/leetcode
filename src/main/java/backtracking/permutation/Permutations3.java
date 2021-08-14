package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutations3 {

    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(arr, 0, res);
        return res;
    }

    private static void backtracking(int[] arr, int idx, List<List<Integer>> res) {
        if (arr.length - 1 == idx) {
            res.add(toList(arr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            backtracking(arr, idx + 1, res);
            swap(arr, i, idx);
        }
    }

    private static List<Integer> toList(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int num : arr) {
            res.add(num);
        }
        return res;
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
