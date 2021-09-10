package dynamic;

import java.util.*;

public class LongestIncrSubseq7 {

    // O(n * log(n)) time | O(n) space
    public static int lis0(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        List<Integer> res = new ArrayList<>();
        res.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int last = res.get(res.size() - 1);
            if (last < arr[i]) {
                res.add(arr[i]);
            } else {
                int j = Collections.binarySearch(res, arr[i]);
                if (j < 0) {
                    j = -(j + 1);
                }
                res.set(j, arr[i]);
            }
        }

        return res.size();
    }

    // O(n ^ 2) time | O(n) space
    public static int lis(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int v : dp) max = Math.max(max, v);

        return max;
    }

    // O(n ^ 2) time | O(n) space
    public static List<Integer> lisList(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                 }
            }
        }

        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
                maxIdx = i;
            }
        }

        Deque<Integer> stack = new LinkedList<>();
        int idx = maxIdx;
        while (idx >= 0) {
            stack.push(arr[idx]);
            idx = prev[idx];
        }
        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        int[] arr0 = {1, 2, 3, 6, -100, -90, -80, -70, -60, 7, 8, 9, 10, -50, -40};
        System.out.println(lis0(arr0));
        System.out.println(lis(arr0));
        System.out.println(lisList(arr0)); // 6
        System.out.println("==============================");

        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
//        System.out.println(lis(arr));
        System.out.println(lis(arr));
        System.out.println(lis0(arr));
        System.out.println(lisList(arr)); // 6
        System.out.println("==============================");

        //           1  2 1 1 2 3
        int[] arr1 = {4,10,4,3,8,9}; // 3
        System.out.println(lis(arr1));
        System.out.println(lis0(arr1));
        System.out.println(lisList(arr1));
        System.out.println("==============================");
//////
        int[] arr2 = {10,9,2,5,3,7,101,18}; // 4
        System.out.println(lis(arr2));
        System.out.println(lis0(arr2));
        System.out.println(lisList(arr2));

        System.out.println("===============================");
//
        int[] arr3 = {1, -10, 20, 30, 2, 3, 4, 5};
        System.out.println(lis(arr3));
        System.out.println(lis0(arr3));
        System.out.println(lisList(arr3));
    }
}
