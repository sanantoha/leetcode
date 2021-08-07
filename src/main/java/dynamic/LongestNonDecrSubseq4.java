package dynamic;

import java.util.*;

public class LongestNonDecrSubseq4 {

    public static int lnds(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int v : dp) {
            max = Math.max(v, max);
        }
        return max;
    }

    public static List<Integer> lndsLst(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int maxIdx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
                maxIdx = i;
            }
        }

        int idx = maxIdx;
        Deque<Integer> stack = new LinkedList<>();
        while (idx >= 0) {
            stack.push(arr[idx]);
            idx = prev[idx];
        }

        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        int[] arr = {-2, -1,3,4,5,2,2,2,2};

        System.out.println(lnds(arr));
        System.out.println(lndsLst(arr));
    }
}
