package dynamic;

import java.lang.reflect.Array;
import java.util.*;

public class LongestDecrSubseq5 {

    public static int lds(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }

    public static List<Integer> ldsList(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && dp[i] < dp[j] + 1) {
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

        int idx = maxIdx;
        Deque<Integer> stack = new LinkedList<>();
        while (idx >= 0) {
            stack.push(arr[idx]);
            idx = prev[idx];
        }

        return new ArrayList<>(stack);
    }

    public static int lds1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        List<Integer> res = new ArrayList<>();
        res.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int prev = res.get(res.size() - 1);
            if (prev > arr[i]) {
                res.add(arr[i]);
            } else {
                int j = revBinarySearch(res, arr[i]);
                if (j < 0) {
                    j = -(j + 1);
                }
                res.set(j, arr[i]);
            }
        }

        return res.size();
    }

    private static int revBinarySearch(List<Integer> arr, int target) {
        int l = 0;
        int r = arr.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (target < arr.get(mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return arr.get(l) == target ? l : -(l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,6,5,4,3,10,14,12};

        System.out.println(lds(arr));
        System.out.println(lds1(arr));
        System.out.println(ldsList(arr));

        int[] arr1 = {100, 10, 9, 8, 7, 6, 5, 90, 80, 70, 60, 50, 40, 30, 20};
        System.out.println(lds(arr1));
        System.out.println(lds1(arr1));
        System.out.println(ldsList(arr1));
//
//        List<Integer> lst = new ArrayList<>();
//        lst.add(10);
//        lst.add(9);
//        lst.add(7);
//        lst.add(5);
//        lst.add(3);
//        lst.add(2);
//        lst.add(1);
//
//        System.out.println(lst);
//
//        System.out.println(revBinarySearch(lst, 8));
    }
}
