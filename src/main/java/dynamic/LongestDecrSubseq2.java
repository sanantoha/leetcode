package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LongestDecrSubseq2 {

    public static int lds(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int[] dp = new int[arr.length];
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && dp[i] < dp[j] + 1) {
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

    public static List<Integer> ldsList(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] dp = new int[arr.length];
        dp[0] = 1;
        int[] prev = new int[arr.length];
        prev[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] == 1) prev[i] = -1;
        }

        int maxInd = 0; int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                maxInd = i;
            }
        }

        int n = maxInd;
        Deque<Integer> stack = new LinkedList<>();
        while (n >= 0) {
            stack.push(arr[n]);
            n = prev[n];
        }
        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,6,5,4,3,10,14,12};

        System.out.println(lds(arr));
        System.out.println(ldsList(arr));

        int[] arr1 = {100, 10, 9, 8, 7, 6, 5, 90, 80, 70, 60, 50, 40, 30, 20};
        System.out.println(lds(arr1));
        System.out.println(ldsList(arr1));
    }
}
