package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Powerset6 {

    public static List<List<Integer>> powerset(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.emptyList());
        if (arr == null || arr.length == 0) return res;

        for (int num : arr) {
            List<List<Integer>> subRes = new ArrayList<>();
            for (List<Integer> lst : res) {
                List<Integer> newLst = new ArrayList<>(lst);
                newLst.add(num);
                subRes.add(newLst);
            }
            res.addAll(subRes);
        }

        return res;
    }

    public static List<List<Integer>> powersetRec(int[] arr) {
        return powersetRec(arr, arr.length - 1);
    }

    private static List<List<Integer>> powersetRec(int[] arr, int idx) {
        if (idx < 0) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }

        int elem = arr[idx];
        List<List<Integer>> subRes = powersetRec(arr, idx - 1);
        int len = subRes.size();
        for (int i = 0; i < len; i++) {
            List<Integer> lst = new ArrayList<>(subRes.get(i));
            lst.add(elem);
            subRes.add(lst);
        }

        return subRes;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(powerset(arr));
        System.out.println(powersetRec(arr));
    }
}
