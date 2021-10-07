package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinRewards3 {

    // O(n ^ 2) time | O(n) space
    private static int minRewards(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] rewards = new int[arr.length];
        Arrays.fill(rewards, 1);

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            if (arr[j] < arr[i]) {
                rewards[i] = rewards[j] + 1;
            } else {
                while (j >= 0 && arr[j] > arr[j + 1]) {
                    rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
                    j--;
                }
            }
        }

        return Arrays.stream(rewards).sum();
    }

    // O(n) time | O(n) space
    private static int minRewards1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int[] rewards = new int[arr.length];
        Arrays.fill(rewards, 1);

        List<Integer> lowerIdxs = getLowerIdxs(arr);
        for (int idx : lowerIdxs) {
            expandLowerIdx(idx, arr, rewards);
        }
        return Arrays.stream(rewards).sum();
    }

    private static void expandLowerIdx(int idx, int[] arr, int[] rewards) {
        int l = idx - 1;
        while (l >= 0 && arr[l] > arr[l + 1]) {
            rewards[l] = Math.max(rewards[l], rewards[l + 1] + 1);
            l--;
        }

        int r = idx + 1;
        while (r < arr.length && arr[r - 1] < arr[r]) {
            rewards[r] = rewards[r - 1] + 1;
            r++;
        }
    }

    private static List<Integer> getLowerIdxs(int[] arr) {
        List<Integer> lowerIdxs = new ArrayList<>();

        if (arr.length == 1) {
            lowerIdxs.add(0);
            return lowerIdxs;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] < arr[i + 1]) lowerIdxs.add(i);
            if (i == arr.length - 1 && arr[i - 1] > arr[i]) lowerIdxs.add(i);
            if (i == 0 || i == arr.length - 1) continue;
            if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) lowerIdxs.add(i);
        }

        return lowerIdxs;
    }

    // O(n) time | O(n) space
    private static int minRewards2(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int[] rewards = new int[arr.length];
        Arrays.fill(rewards, 1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                rewards[i] = rewards [i - 1] + 1;
            }
        }

        for (int j = arr.length - 2; j >= 0; j--) {
            if (arr[j] > arr[j + 1]) {
                rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
            }
        }

        return Arrays.stream(rewards).sum();
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1, 3, 6, 7, 9, 5}; //  25

        System.out.println(minRewards(arr));
        System.out.println(minRewards1(arr));
        System.out.println(minRewards2(arr));
    }


}
