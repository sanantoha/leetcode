package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Powerset4 {

    public static List<List<Integer>> powerset(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length == 0) return res;

        res.add(new ArrayList<>());

        for (int num : arr) {
            List<List<Integer>> subSet = new ArrayList<>();
            for (List<Integer> lst : res) {
                List<Integer> nlst = new ArrayList<>(lst);
                nlst.add(num);
                subSet.add(nlst);
            }
            res.addAll(subSet);
        }

        return res;
    }

    public static List<List<Integer>> powersetRec(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();
        return powersetRec(arr, arr.length - 1);
    }

    private static List<List<Integer>> powersetRec(int[] arr, int idx) {
        if (idx < 0) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        int elem = arr[idx];
        List<List<Integer>> res = powersetRec(arr, idx - 1);
        int size = res.size();
        for (int i = 0; i < size; i++) {
            List<Integer> lst = new ArrayList<>(res.get(i));
            lst.add(elem);
            res.add(lst);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(powerset(arr));
        System.out.println(powersetRec(arr));
    }
}
