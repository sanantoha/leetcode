package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Powerset5 {

    public static List<List<Integer>> powerset(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.emptyList());
        if (arr == null || arr.length == 0) return res;

        for (int num : arr) {
            List<List<Integer>> subSet = new ArrayList<>();
            for (List<Integer> lst : res) {
                List<Integer> nLst = new ArrayList<>(lst);
                nLst.add(num);
                subSet.add(nLst);
            }

            res.addAll(subSet);
        }

        return res;
    }

    public static List<List<Integer>> powersetRec(int[] arr) {
        return powersetRec(arr, arr.length - 1);
    }

    private static List<List<Integer>> powersetRec(int[] arr, int idx) {
        if (idx < 0) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(Collections.emptyList());
            return res;
        }
        int elem = arr[idx];
        List<List<Integer>> subRes = powersetRec(arr, idx - 1);
        int size = subRes.size();
        for (int i = 0; i < size; i++) {
            List<Integer> nLst = new ArrayList<>(subRes.get(i));
            nLst.add(elem);
            subRes.add(nLst);
        }
        return subRes;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(powerset(arr));
        System.out.println(powersetRec(arr));
    }
}
