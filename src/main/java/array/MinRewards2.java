package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinRewards2 {

    public static int minRewards(int[] arr) {
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

    public static int minRewards1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] rewards = new int[arr.length];
        Arrays.fill(rewards, 1);

        List<Integer> idxs = getMinIdx(arr);
        for (int minIdx : idxs) {
            expandMinIdx(arr, rewards, minIdx);
        }
        return Arrays.stream(rewards).sum();
    }

    private static void expandMinIdx(int[] arr, int[] rewards, int minIdx) {
        int l = minIdx - 1;
        while (l >= 0 && arr[l] > arr[l + 1]) {
            rewards[l] = Math.max(rewards[l], rewards[l + 1] + 1);
            l--;
        }

        int r = minIdx + 1;
        while (r < arr.length && arr[r - 1] < arr[r]) {
            rewards[r] = rewards[r - 1] + 1;
            r++;
        }
    }

    private static List<Integer> getMinIdx(int[] arr) {
        List<Integer> res = new ArrayList<>();
        if (arr.length == 1) {
            res.add(arr[0]);
            return res;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] < arr[i + 1]) res.add(i);
            if (i == arr.length - 1 && arr[i] < arr[i - 1]) res.add(i);
            if (i == 0 || i == arr.length - 1) continue;
            if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) res.add(i);
        }
        return res;
    }

    public static int minRewards2(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int[] rewards = new int[arr.length];
        Arrays.fill(rewards, 1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                rewards[i] = rewards[i - 1] + 1;
            }
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
