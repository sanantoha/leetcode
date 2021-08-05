package dynamic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class LongestIncrSubseq1 {

    public static int lis(int[] arr) {
        if (arr.length == 0) return 0;

        int[] dp = new int[arr.length];
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[i] + 1;
                }
            }
        }

        int max = 0;
        for (int v : dp) {
            if (v > max) {
                max = v;
            }
        }

        return max;
    }


    public static List<Integer> lisList(int[] arr) {
        if (arr.length == 0) return Collections.emptyList();

        int[] dp = new int[arr.length];
        dp[0] = 1;
        int[] prev = new int[arr.length];
        prev[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[i] + 1;
                    prev[i] = j;
                }
            }
        }

        int maxInd = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
                maxInd = i;
            }
        }

        Deque<Integer> res = new ArrayDeque<>();
        int ni = maxInd;
        while (ni >= 0) {
            res.addFirst(arr[ni]);
            ni = prev[ni];
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {

        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(arr));
        System.out.println(lisList(arr)); // 6
        //           1  2 1 1 2 3
        int[] arr1 = {4,10,4,3,8,9}; // 3
        System.out.println(lis(arr1));
        System.out.println(lisList(arr1));
////
        int[] arr2 = {10,9,2,5,3,7,101,18}; // 4
        System.out.println(lis(arr2));
        System.out.println(lisList(arr2));
//
        int[] arr3 = {1, -10, 20, 30, 2, 3, 4, 5};
        System.out.println(lis(arr3));
        System.out.println(lisList(arr3));
    }
}
