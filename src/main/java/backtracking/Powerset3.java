package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Powerset3 {

    public static List<List<Integer>> powerset(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : arr) {
            List<List<Integer>> subResult = new ArrayList<>();
            for (List<Integer> lst : result) {
                List<Integer> nlst = new ArrayList<>(lst);
                nlst.add(num);
                subResult.add(nlst);
            }
            result.addAll(subResult);
        }

        return result;
    }

    public static List<List<Integer>> powersetRec(int[] arr) {
        return rec(arr, arr.length - 1);
    }

    private static List<List<Integer>> rec(int[] arr, int idx) {
        if (idx < 0) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        int elem = arr[idx];
        List<List<Integer>> subResult = rec(arr, idx - 1);
        int size = subResult.size();
        for (int i = 0; i < size; i++) {
            List<Integer> lst = new ArrayList<>(subResult.get(i));
            lst.add(elem);
            subResult.add(lst);
        }
        return subResult;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(powerset(arr));
        System.out.println(powersetRec(arr));
    }
}