package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private static List<Integer> toList(int[] arr) {
        List<Integer> lst = new ArrayList<>();
        for (int v : arr) {
            lst.add(v);
        }
        return lst;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void backtracking(List<List<Integer>> result, int[] arr, int start) {
        if (start == arr.length) {
            result.add(toList(arr));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, i, start);
            backtracking(result, arr, start + 1);
            swap(arr, i, start);
        }
    }

    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, arr, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};

        System.out.println(permute(arr));
    }
}
