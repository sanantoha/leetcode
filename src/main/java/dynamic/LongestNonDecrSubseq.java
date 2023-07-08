package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LongestNonDecrSubseq {

    // O(n ^ 2) time | O(n) space
    public static int lnds(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] lengths = new int[arr.length];
        Arrays.fill(lengths, 1);
        int maxLengths = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && lengths[i] < lengths[j] + 1) {
                    lengths[i] = lengths[j] + 1;
                }
            }
            if (maxLengths < lengths[i]) {
                maxLengths = lengths[i];
            }
        }
        return maxLengths;
    }

    // O(n ^ 2) time | O(n) space
    public static List<Integer> lndsList(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] lengths = new int[arr.length];
        Arrays.fill(lengths, 1);
        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);
        int maxLengths = 0;
        int maxIdx = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && lengths[i] < lengths[j] + 1) {
                    lengths[i] = lengths[j] + 1;
                    prev[i] = j;
                }
            }
            if (maxLengths < lengths[i]) {
                maxLengths = lengths[i];
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
    private static int lnds1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

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
                }
                res.set(j, arr[i]);
            }
        }
        return res.size();
    }

    private static int binarySearch(List<Integer> arr, int target) {
        int l = 0;
        int r = arr.size() - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target >= arr.get(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (arr.get(l) == target) ? l : -(l + 1);
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
            if (arr[indices[mid]] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 3, 4, 5, 2, 2, 2, 2}; // 5

        System.out.println(lnds(arr));
        System.out.println(lnds1(arr));
        System.out.println(lndsList(arr));
        System.out.println(lndsList1(arr));
    }
}