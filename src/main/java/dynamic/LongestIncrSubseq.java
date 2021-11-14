package dynamic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestIncrSubseq {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    // O(N * log(N)) time | O(N) space
    public static int lis0(int[] arr) {
        if (arr == null || arr.length == 0) return 0;


        List<Integer> res = new ArrayList<>();
        res.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int prev = res.get(res.size() - 1);
            if (prev < arr[i]) {
                res.add(arr[i]);
            } else if (prev > arr[i]) { // -100 - 90
                int j = Collections.binarySearch(res, arr[i]);
                if (j < 0) {
                    j = -(j + 1);
                }
                res.set(j, arr[i]);
            }

        }
        return res.size();
    }

    // O(N * log(N)) time | O(N) space
    // NOT working
    public static List<Integer> lisList0(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();


        List<Integer> res = new ArrayList<>();
        res.add(arr[0]);
        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);
        int maxIdx = 0;
        int k = 0;
        for (int i = 1; i < arr.length; i++) {
            int prevVal = res.get(res.size() - 1);
            if (prevVal < arr[i]) {
                res.add(arr[i]);
                prev[i] = i - 1;
//                k = i;
            } else if (prevVal > arr[i]) { // -100 - 90
                int j = Collections.binarySearch(res, arr[i]);
                if (j < 0) {
                    j = -(j + 1);
                }
                res.set(j, arr[i]);
                prev[i] = j - 1;
//                k = Math.max(k, j);
            }

        }
        System.out.println(k);
//        System.out.println(res);
        System.out.println(Arrays.toString(prev));
        return buildList(arr, prev, 12);
    }

    // O(n ^ 2) time | O(n) space
    public static int lis(int[] arr) {
        if (arr.length == 0) return 0;

        int[] lengths = new int[arr.length];
        Arrays.fill(lengths, 1);
        int maxV = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lengths[i] = Math.max(lengths[i], lengths[j] + 1);
                }
            }
            if (lengths[i] > maxV) {
                maxV = lengths[i];
            }
        }
        return maxV;
    }

    // O(n ^ 2) time | O(n) space
    public static List<Integer> lisList(int[] arr) {
        if (arr.length == 0) return Collections.emptyList();

        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);
        int[] lengths = new int[arr.length];
        Arrays.fill(lengths, 1);

        int maxInd = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lengths[i] < lengths[j] + 1) {
                    lengths[i] = lengths[j] + 1;
                    prev[i] = j;
                }
            }
            if (lengths[i] >= lengths[maxInd]) {
                maxInd = i;
            }
        }

        return buildList(arr, prev, maxInd);
    }

    private static List<Integer> buildList(int[] arr, int[] prev, int maxInd) {
        int ni = maxInd;
        Deque<Integer> lst = new LinkedList<>();
        while (ni >= 0) {
            lst.addFirst(arr[ni]);
            ni = prev[ni];
        }
        return new ArrayList<>(lst);
    }



    // O(n * log(n)) time | O(n) space
    public static List<Integer> lisListFast(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] indices = new int[arr.length + 1];
        Arrays.fill(indices, -1);
        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);

        int length = 0;

        for (int i = 0; i < arr.length; i++) {
            int newLength = binarySearch(arr, indices, 1, length, arr[i]);
            prev[i] = indices[newLength - 1];
            indices[newLength] = i;
            length = Math.max(length, newLength);
        }

        return buildList(arr, prev, indices[length]);
    }

    private static int binarySearch(int[] arr, int[] indices, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[indices[mid]] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        int[] arr0 = {1, 2, 3, 6, -100, -90, -80, -70, -60, 7, 8, 9, 10, -50, -40};
        System.out.println(lengthOfLIS(arr0));
        System.out.println(lis0(arr0));
        System.out.println(lisList(arr0)); // 6
        System.out.println(lisListFast(arr0)); // 6
        System.out.println("==============================");

//        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
//
//        System.out.println(lengthOfLIS(arr));
//        System.out.println(lis0(arr));
//        System.out.println(lisList(arr)); // 6
//        System.out.println("==============================");
//
//        //           1  2 1 1 2 3
//        int[] arr1 = {4,10,4,3,8,9}; // 3
//        System.out.println(lengthOfLIS(arr1));
//        System.out.println(lis(arr1));
//        System.out.println(lis0(arr1));
//        System.out.println(lisList(arr1));
//        System.out.println("==============================");
////////
//        int[] arr2 = {10,9,2,5,3,7,101,18}; // 4
//        System.out.println(lis(arr2));
//        System.out.println(lis0(arr2));
//        System.out.println(lisList(arr2));
//
//        System.out.println("===============================");
////
//        int[] arr3 = {1, -10, 20, 30, 2, 3, 4, 5};
//        System.out.println(lis(arr3));
//        System.out.println(lis0(arr3));
//        System.out.println(lisList(arr3));


    }
}
