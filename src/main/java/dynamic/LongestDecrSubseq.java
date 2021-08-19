package dynamic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class LongestDecrSubseq {

    // O (N^2) time | O(N) space
    public static int lds(int[] arr) {
        if (arr.length == 0) return 0;

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }

    // O (N * log(N)) time | O(N) space
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

    // O (N^2) time | O(N) space
    public static List<Integer> ldsList(int[] arr) {
        if (arr.length == 0) return Collections.emptyList();

        int[] prev = new int[arr.length];
        prev[0] = -1;
        int[] dp = new int[arr.length];
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && (dp[i] < dp[j] + 1)) {
                    dp[i] = dp[i] + 1;
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

        Deque<Integer> lst = new ArrayDeque<>();
        int ni = maxInd;
        while (ni >= 0) {
            lst.addFirst(arr[ni]);
            ni = prev[ni];
        }
        return new ArrayList<>(lst);
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 9, 11, 7, 100, 2};

        System.out.println(lds(arr));
        System.out.println(lds1(arr));
        System.out.println(ldsList(arr));

        int[] arr1 = {100, 10, 9, 8, 7, 6, 5, 90, 80, 70, 60, 50, 40, 30, 20};
        System.out.println(lds(arr1));
        System.out.println(lds1(arr1));
        System.out.println(ldsList(arr1));

        int[] arr2 = {};
        System.out.println(lds(arr2));
        System.out.println(lds1(arr2));
        System.out.println(ldsList(arr2));
    }
}
