package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncrSubseq11 {

    // O(n ^ 2) time | O(n) space
    public static int lis0(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int[] lengths = new int[arr.length];
        Arrays.fill(lengths, 1);

        int maxLength = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lengths[i] < lengths[j] + 1) {
                    lengths[i] = lengths[j] + 1;
                }
            }

            if (maxLength < lengths[i]) {
                maxLength = lengths[i];
            }
        }


        return maxLength;
    }

    // O(n * log(n)) time | O(n) space
    public static int lis(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        List<Integer> lengths = new ArrayList<>();
        lengths.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int prev = lengths.get(lengths.size() - 1);
            if (prev < arr[i]) {
                lengths.add(arr[i]);
            } else {
                int j = Collections.binarySearch(lengths, arr[i]);
                if (j < 0) {
                    j = -(j + 1);
                }
                lengths.set(j, arr[i]);
            }
        }


        return lengths.size();
    }

    // O(n ^ 2) time | O(n) space
    public static List<Integer> lisList0(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] lengths = new int[arr.length];
        Arrays.fill(lengths, 1);
        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);

        int maxLength = 0;
        int maxIdx = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lengths[i] < lengths[j] + 1) {
                    lengths[i] = lengths[j] + 1;
                    prev[i] = j;
                }
            }
            if (maxLength < lengths[i]) {
                maxLength = lengths[i];
                maxIdx = i;
            }
        }

        return buildList(arr, prev, maxIdx);
    }

    // O(n * log(n)) time | O(n) space
    public static List<Integer> lisList(int[] arr) {
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

    private static List<Integer> buildList(int[] arr, int[] prev, int maxIdx) {
        List<Integer> seq = new ArrayList<>();
        int idx = maxIdx;
        while (idx >= 0) {
            seq.add(arr[idx]);
            idx = prev[idx];
        }
        Collections.reverse(seq);
        return seq;
    }

    public static void main(String[] args) {
        int[] arr0 = {1, 2, 3, 6, -100, -90, -80, -70, -60, 7, 8, 9, 10, -50, -40};
        System.out.println(lis0(arr0));
        System.out.println(lis(arr0));
        System.out.println(lisList(arr0)); // 9
        System.out.println(lisList0(arr0)); // 9
        System.out.println("==============================");

        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
//        System.out.println(lis(arr));
        System.out.println(lis(arr));
        System.out.println(lis0(arr));
        System.out.println(lisList(arr)); // 6
        System.out.println(lisList0(arr)); // 6
        System.out.println("==============================");

        //           1  2 1 1 2 3
        int[] arr1 = {4,10,4,3,8,9}; // 3
        System.out.println(lis(arr1));
        System.out.println(lis0(arr1));
        System.out.println(lisList(arr1));
        System.out.println(lisList0(arr1));
        System.out.println("==============================");
//////
        int[] arr2 = {10,9,2,5,3,7,101,18}; // 4
        System.out.println(lis(arr2));
        System.out.println(lis0(arr2));
        System.out.println(lisList(arr2));
        System.out.println(lisList0(arr2));

        System.out.println("===============================");
//
        int[] arr3 = {1, -10, 20, 30, 2, 3, 4, 5}; // 5
        System.out.println(lis(arr3));
        System.out.println(lis0(arr3));
        System.out.println(lisList(arr3));
        System.out.println(lisList0(arr3));
    }
}
