package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Powerset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        System.out.println(powerset(arr));
        System.out.println(powersetRec(arr));
    }

    public static List<List<Integer>> powerset(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

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

    private static List<List<Integer>> powersetRecursion(int[] arr, int ind) {
        if (ind < 0) {
            List<List<Integer>> empty = new ArrayList<>();
            empty.add(new ArrayList<>());
            return empty;
        }

        int ele = arr[ind];

        List<List<Integer>> subsets = powersetRecursion(arr, ind - 1);
        int size = subsets.size();
        for (int i = 0; i < size; i++) {
            List<Integer> newLst = new ArrayList<>(subsets.get(i));
            newLst.add(ele);
            subsets.add(newLst);
        }
        return subsets;
    }
}
