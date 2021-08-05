package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Powerset1 {

    public static List<List<Integer>> powerset(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (arr == null || arr.length == 0) return result;

        for (int v : arr) {
            List<List<Integer>> subset = new ArrayList<>();
            for (List<Integer> lst : result) {
                List<Integer> newLst = new ArrayList<>(lst);
                newLst.add(v);
                subset.add(newLst);
            }
            result.addAll(subset);
        }

        return result;
    }

    public static List<List<Integer>> powersetRec(int[] arr) {
        return powersetRecursion(arr, arr.length - 1);
    }

    private static List<List<Integer>> powersetRecursion(int[] arr, int idx) {
        if (idx < 0) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        int ele = arr[idx];

        List<List<Integer>> subset = powersetRecursion(arr, idx - 1);
        int size = subset.size();
        for (int i = 0; i < size; i++) {
            List<Integer> newLst = new ArrayList<>(subset.get(i));
            newLst.add(ele);
            subset.add(newLst);
        }
        return subset;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        System.out.println(powerset(arr));
        System.out.println(powersetRec(arr));
    }
}
