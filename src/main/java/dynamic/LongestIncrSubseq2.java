package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LongestIncrSubseq2 {

    public static int lis(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int[] dp = new int[arr.length];
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }

    public static List<Integer> lisList(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] dp = new int[arr.length];
        dp[0] = 1;
        int[] pred = new int[arr.length];
        pred[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    pred[i] = j;
                }
            }
            if (dp[i] == 1) pred[i] = -1;
        }

        int maxInd = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
                maxInd = i;
            }
        }

        Deque<Integer> stack = new LinkedList<>();
        int n = maxInd;
        while (n >= 0) {
            stack.push(arr[n]);
            n = pred[n];
        }
        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,2,1,5,6,7,8};

        System.out.println(lis(arr));
        System.out.println(lisList(arr));


        int[] arr1 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(arr1));
        System.out.println(lisList(arr1));
    }
}
