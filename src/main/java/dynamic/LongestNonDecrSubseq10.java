package dynamic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestNonDecrSubseq10 {

    // O(n ^ 2) time | O(n) space
    public static int lnds(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int[] lnds = new int[arr.length];
        Arrays.fill(lnds, 1);
        int maxLnds = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && lnds[i] < lnds[j] + 1) {
                    lnds[i] = lnds[j] + 1;
                }
            }
            if (maxLnds < lnds[i]) {
                maxLnds = lnds[i];
            }
        }
        return maxLnds;
    }

    // O(n ^ 2) time | O(n) space
    public static List<Integer> lndsList(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] lnds = new int[arr.length];
        Arrays.fill(lnds, 1);
        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);

        int maxLnds = 0;
        int maxIdx = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && lnds[i] < lnds[j] + 1) {
                    lnds[i] = lnds[j] + 1;
                    prev[i] = j;
                }
            }
            if (maxLnds < lnds[i]) {
                maxLnds = lnds[i];
                maxIdx = i;
            }
        }
        return buildList(arr, prev, maxIdx);
    }

    private static List<Integer> buildList(int[] arr, int[] prev, int maxIdx) {
        List<Integer> res = new ArrayList<>();
        int idx = maxIdx;
        while (idx >= 0) {
            res.add(arr[idx]);
            idx = prev[idx];
        }
        Collections.reverse(res);
        return res;
    }

    // O(n * log(n)) time | O(n) space
    public static int lnds1(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        List<Integer> res = new ArrayList<>();
        res.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int prev = res.get(res.size() - 1);
            if (prev <= arr[i]) {
                res.add(arr[i]);
            } else {
                int j = binarySearch(res, arr[i]);
                if (j < 0) {
                    j = -(j + 1);
                } else {
                    j++;
                }
                res.set(j, arr[i]);
            }
        }

        return res.size();
    }

    private static int binarySearch(List<Integer> lst, int target) {
        int l = 0;
        int r = lst.size() - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target < lst.get(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    // O(n * log(n)) time | O(n) space
    public static List<Integer> lndsList1(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] indices = new int[arr.length + 1];
        Arrays.fill(indices, -1);
        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);

        int length = 0;

        for (int i = 0; i < arr.length; i++) {
            int maxLength = binarySearch(arr, indices, 1, length, arr[i]);
            prev[i] = indices[maxLength - 1];
            indices[maxLength] = i;
            length = Math.max(length, maxLength);
        }

        return buildList(arr, prev, indices[length]);
    }

    private static int binarySearch(int[] arr, int[] indices, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target < arr[indices[mid]]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-1,2, 3,4,5,2,2,2,2, 3};

//        int[] arr = {-1, 3, 4, 5, 2, 2, 2, 2}; // 5

        System.out.println(lnds(arr));
        System.out.println(lnds1(arr));
        System.out.println(lndsList(arr));
        System.out.println(lndsList1(arr));
    }
}
