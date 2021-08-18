package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinRewards1 {

    public static int minRewards(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] rewards = new int[arr.length];
        Arrays.fill(rewards, 1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                rewards[i] = rewards[i - 1] + 1;
            } else {
                int j = i - 1;
                while (j >= 0 && arr[j] > arr[j + 1]) {
                    rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
                    j--;
                }
            }
        }

        return Arrays.stream(rewards).sum();
    }

    public static int minRewards1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] rewards = new int[arr.length];
        Arrays.fill(rewards, 1);

        List<Integer> minIdxs = getMinIdxs(arr);
        for (int idx : minIdxs) {
            expandMinIdxs(arr, rewards, idx);
        }

        return Arrays.stream(rewards).sum();
    }

    private static List<Integer> getMinIdxs(int[] arr) {
        List<Integer> idxs = new ArrayList<>();

        if (arr.length == 1) {
            idxs.add(0);
            return idxs;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] < arr[i + 1]) {
                idxs.add(0);
            }
            if (i == arr.length - 1 && arr[i - 1] > arr[i]) {
                idxs.add(arr.length - 1);
            }
            if (i == 0 || i == arr.length - 1) continue;

            if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) idxs.add(i);
        }
        return idxs;
    }

    private static void expandMinIdxs(int[] arr, int[] rewards, int idx) {
        int r = idx + 1;
        while (r < arr.length && arr[r] > arr[r - 1]) {
            rewards[r] = rewards[r - 1] + 1;
            r++;
        }

        int l = idx - 1;
        while (l >= 0 && arr[l + 1] < arr[l]) {
            rewards[l] = Math.max(rewards[l], rewards[l + 1] + 1);
            l--;
        }
    }

    public static int minRewards2(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] rewards = new int[arr.length];
        Arrays.fill(rewards, 1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) rewards[i] = rewards[i - 1] + 1;
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
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
