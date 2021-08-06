package dynamic;

import java.util.*;

public class LongestIncrSubSeq5 {

    public static int lis(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

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

        int max = Integer.MIN_VALUE;
        for (int v : dp) {
            max = Math.max(v, max);
        }

        return max;
    }

    public static List<Integer> lisList(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] dp = new int[arr.length];
        int[] prev = new int[arr.length];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int maxInd = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) {
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
        int[] arr = {1,2,3,4,3,2,1,5,6,7,8};

        System.out.println(lis(arr));
        System.out.println(lisList(arr));


        int[] arr1 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(arr1));
        System.out.println(lisList(arr1));

        int[] arr2 = {1,2,3,4,5,-5,-4, 3,-2,1,-6,-8,-1};
        System.out.println(lis(arr2));
        System.out.println(lisList(arr2));
    }

    // 1,2,3,4,3,2,1,5,6,7,8
    // 1 2 3
}
