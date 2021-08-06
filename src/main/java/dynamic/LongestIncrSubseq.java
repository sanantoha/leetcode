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

    public static int lis(int[] arr) {
        if (arr.length == 0) return 0;

        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

//        System.out.println(Arrays.toString(dp));

        int maxV = 1;
        for (int value : dp) {
            if (value > maxV) maxV = value;
        }
        return maxV;
    }

    public static List<Integer> lisList(int[] arr) {
        if (arr.length == 0) return Collections.emptyList();

        int[] prev = new int[arr.length];
        prev[0] = -1;
        int[] dp = new int[arr.length];
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] == 1) {
                prev[i] = -1;
            }
        }

        int maxInd = 0;
        int maxV = 1;
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] > maxV) {
                maxV = dp[i];
                maxInd = i;
            }
        }
//        System.out.println(Arrays.toString(ind));
        int ni = maxInd;
        Deque<Integer> lst = new LinkedList<>();
        while (ni >= 0) {
            lst.addFirst(arr[ni]);
            ni = prev[ni];
        }
        return new ArrayList<>(lst);
    }


    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
//        System.out.println(lis(arr));
        System.out.println(lengthOfLIS(arr));
//        System.out.println(lisList(arr)); // 6
        //           1  2 1 1 2 3
//        int[] arr1 = {4,10,4,3,8,9}; // 3
//        System.out.println(lis(arr1));
//        System.out.println(lisList(arr1));
//////
//        int[] arr2 = {10,9,2,5,3,7,101,18}; // 4
//        System.out.println(lis(arr2));
//        System.out.println(lisList(arr2));
////
//        int[] arr3 = {1, -10, 20, 30, 2, 3, 4, 5};
//        System.out.println(lis(arr3));
//        System.out.println(lisList(arr3));


    }
}
