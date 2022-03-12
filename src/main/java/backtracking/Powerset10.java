package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Powerset10 {

    // O(n * 2 ^ n) time | O(n * 2 ^ n) space
    public static List<List<Integer>> powerset(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.emptyList());

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

    // O(n * 2 ^ n) time | O(n * 2 ^ n) space
    public static List<List<Integer>> powersetRec(int[] arr) {
        return powersetRec(arr, arr.length - 1);
    }

    private static List<List<Integer>> powersetRec(int[] arr, int idx) {
        if (idx < 0) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(Collections.emptyList());
            return res;
        }

        int num = arr[idx];
        List<List<Integer>> subRes = powersetRec(arr, idx - 1);
        int size = subRes.size();

        for (int i = 0; i < size; i++) {
            List<Integer> newLst = new ArrayList<>(subRes.get(i));
            newLst.add(num);
            subRes.add(newLst);
        }

        return subRes;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(powerset(arr));
        System.out.println(powersetRec(arr));
    }
}
