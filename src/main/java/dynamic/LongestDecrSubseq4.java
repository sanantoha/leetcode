package dynamic;

import java.util.*;

public class LongestDecrSubseq4 {

    // O(n ^ 2) time | O(n) space
    public static int lds(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] lds = new int[arr.length];
        Arrays.fill(lds, 1);

        int maxVal = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
            if (maxVal < lds[i]) {
                maxVal = lds[i];
            }
        }
        return maxVal;
    }

    // O(n ^ 2) time | O(n) space
    public static List<Integer> ldsList(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] lds = new int[arr.length];
        Arrays.fill(lds, 1);
        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);

        int maxIdx = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                    prev[i] = j;
                }
            }
            if (lds[maxIdx] < lds[i]) {
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
    public static int lds1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        List<Integer> res = new ArrayList<>();
        res.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int prev = res.get(res.size() - 1);
            if (prev > arr[i]) {
                res.add(arr[i]);
            } else {
                int j = Collections.binarySearch(res, arr[i], Comparator.reverseOrder());
                if (j < 0) {
                    j = -(j + 1);
                }
                res.set(j, arr[i]);
            }
        }
        return res.size();
    }

    // O(n * log(n)) time | O(n) space
    public static List<Integer> ldsList1(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] indices = new int[arr.length + 1];
        Arrays.fill(indices, -1);
        int[] prev = new int[arr.length];
        Arrays.fill(indices, -1);

        int length = 0;

        for (int i = 0; i < arr.length; i++) {
            int maxLength = binarySearch(arr, indices, 1, length, arr[i]);
            indices[maxLength] = i;
            prev[i] = indices[maxLength - 1];
            length = Math.max(length, maxLength);
        }

        return buildList(arr, prev, indices[length]);
    }

    private static int binarySearch(int[] arr, int[] indices, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >>> 1;

            if (target < arr[indices[mid]]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,6,5,4,3,10,14,12}; // 5

        System.out.println(lds(arr));
        System.out.println(lds1(arr));
        System.out.println(ldsList(arr));
        System.out.println(ldsList1(arr));

        int[] arr1 = {100, 10, 9, 8, 7, 6, 5, 90, 80, 70, 60, 50, 40, 30, 20}; // 9
        System.out.println(lds(arr1));
        System.out.println(lds1(arr1));
        System.out.println(ldsList(arr1));
        System.out.println(ldsList1(arr1));
    }
}
