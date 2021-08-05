package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Powerset2 {

    public static List<List<Integer>> powerset(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        result.add(new ArrayList<>());

        for (int i = 0; i < arr.length; i++) {
            List<List<Integer>> subRes = new ArrayList<>();
            for (List<Integer> lst : result) {
                List<Integer> nLst = new ArrayList<>(lst);
                nLst.add(arr[i]);
                subRes.add(nLst);
            }
            result.addAll(subRes);
        }

        return result;
    }

    public static List<List<Integer>> powersetRec(int[] arr) {
        return powersetRecursive(arr, arr.length - 1);
    }

    private static List<List<Integer>> powersetRecursive(int[] arr, int idx) {
        if (idx < 0) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        int elem = arr[idx];
        List<List<Integer>> subRes = powersetRecursive(arr, idx - 1);
        int size = subRes.size();
        for (int i = 0; i < size; i++) {
            List<Integer> nLst = new ArrayList<>(subRes.get(i));
            nLst.add(elem);
            subRes.add(nLst);
        }
        return subRes;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        System.out.println(powerset(arr));

        System.out.println(powersetRec(arr));
    }
}
