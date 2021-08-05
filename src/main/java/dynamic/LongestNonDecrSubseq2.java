package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LongestNonDecrSubseq2 {

    public static int lnds(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int[] dp = new int[arr.length];
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
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

    public static List<Integer> lndsLst(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] dp = new int[arr.length];
        dp[0] = 1;
        int[] prev = new int[arr.length];
        prev[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
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

        Deque<Integer> stack = new LinkedList<>();
        int n = maxInd;
        while (n >= 0) {
            stack.push(arr[n]);
            n = prev[n];
        }
        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        int[] arr = {-1,3,4,5,2,2,2,2};

        System.out.println(lnds(arr));
        System.out.println(lndsLst(arr));
    }
}
