package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinRewards7 {

    // O(n ^ 2) time | O(n) space
    private static int minRewards(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] res = new int[arr.length];
        Arrays.fill(res, 1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                res[i] = res[i - 1] + 1;
            } else {
                int j = i - 1;
                while (j >= 0 && arr[j] > arr[j + 1]) {
                    res[j] = Math.max(res[j], res[j + 1] + 1);
                    j--;
                }
            }
        }
        return Arrays.stream(res).sum();
    }

    // O(n) time | O(n) space
    private static int minRewards1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] res = new int[arr.length];
        Arrays.fill(res, 1);

        List<Integer> minIdxs = getMinIdxs(arr);
        for (int idx : minIdxs) {
            extendMin(arr, res, idx);
        }
        return Arrays.stream(res).sum();
    }

    private static void extendMin(int[] arr, int[] res, int idx) {
        int l = idx - 1;
        while (l >= 0 && arr[l] > arr[l + 1]) {
            res[l] = Math.max(res[l], res[l + 1] + 1);
            l--;
        }

        int r = idx + 1;
        while (r < arr.length && arr[r - 1] < arr[r]) {
            res[r] = res[r - 1] + 1;
            r++;
        }
    }

    private static List<Integer> getMinIdxs(int[] arr) {
        List<Integer> res = new ArrayList<>();

        if (arr.length == 1) {
            res.add(0);
            return res;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] < arr[i + 1]) res.add(i);
            if (i == arr.length - 1 && arr[i - 1] > arr[i]) res.add(i);
            if (i == 0 || i == arr.length - 1) continue;
            if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) res.add(i);
        }

        return res;
    }

    // O(n) time | O(n) space
    private static int minRewards2(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] res = new int[arr.length];
        Arrays.fill(res, 1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                res[i] = res[i - 1] + 1;
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i + 1] < arr[i]) {
                res[i] = Math.max(res[i + 1] + 1, res[i]);
            }
        }

        return Arrays.stream(res).sum();
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1, 3, 6, 7, 9, 5}; //  25

        System.out.println(minRewards(arr));
        System.out.println(minRewards1(arr));
        System.out.println(minRewards2(arr));
    }
}
