package dynamic;

import java.lang.reflect.Array;
import java.util.*;

public class LongestNonDecrSubseq5 {

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
            max = Math.max(max, v);
        }
        return max;
    }

    public static List<Integer> lndsList(int[] arr) {
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

    // does not work
    public static int lnds0(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        List<Integer> res = new ArrayList<>();
        res.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int last = res.get(res.size() - 1);
            if (last <= arr[i]) res.add(arr[i]);
            else {
                int j = Collections.binarySearch(res, arr[i]);
                if (j < 0) {
                    j = -(j + 1);
                }
                res.set(j, arr[i]);
            }
        }
        System.out.println(res);
        return res.size();
    }

    public static void main(String[] args) {
        int[] arr = {-2, -1,3,4,5,2,2,2,2};

        System.out.println(lnds(arr));
        System.out.println(lnds0(arr));
        System.out.println(lndsList(arr));
    }
}
