package dynamic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class LongestDecrSubseq {

    public static int lds(int[] arr) {
        if (arr.length == 0) return 0;

        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

//        System.out.println(Arrays.toString(dp));

        int max = 0;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }

//    public static List<Integer> ldsList(int[] arr) {
//
//        List<Integer> lst = new ArrayList<>();
//        List<Integer> longestLst = new ArrayList<>();
//        int longestCnt = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int currMin = Integer.MAX_VALUE;
//            for (int j = i; j < arr.length; j++) {
//                if (arr[j] < currMin) {
//                    lst.add(arr[j]);
//                    currMin = arr[j];
//                }
//            }
//
//            if (longestCnt < lst.size()) {
//                longestCnt = lst.size();
//                longestLst = new ArrayList<>(lst);
//            }
//            lst.clear();
//        }
//
//        return longestLst;
//    }

    public static List<Integer> ldsList(int[] arr) {
        if (arr.length == 0) return Collections.emptyList();

        int[] prev = new int[arr.length];
        prev[0] = -1;
        int[] dp = new int[arr.length];
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && (dp[i] < dp[j] + 1)) {
                    dp[i] = dp[i] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] == 1) prev[i] = -1;
        }

        int maxInd = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                maxInd = i;
            }
        }

        Deque<Integer> lst = new ArrayDeque<>();
        int ni = maxInd;
        while (ni >= 0) {
            lst.addFirst(arr[ni]);
            ni = prev[ni];
        }
        return new ArrayList<>(lst);
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 9, 11, 7, 100, 2};

        System.out.println(lds(arr));
        System.out.println(ldsList(arr));

        int[] arr1 = {100, 10, 9, 8, 7, 6, 5, 90, 80, 70, 60, 50, 40, 30, 20};
        System.out.println(lds(arr1));
        System.out.println(ldsList(arr1));

        int[] arr2 = {};
        System.out.println(lds(arr2));
        System.out.println(ldsList(arr2));
    }
}
