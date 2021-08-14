package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutations1 {

    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr,0, result);
        return result;
    }

    private static List<Integer> toList(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    private static void backtrack(int[] arr, int start, List<List<Integer>> result) {
        if (arr.length == start) {
            result.add(toList(arr));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, i, start);
            backtrack(arr, start + 1, result);
            swap(arr, i, start);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};

        System.out.println(permute(arr));
    }
}
