package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinRewards {

    public static int minRewards(int[] scores) {
        if (scores == null || scores.length == 0) return 0;
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);

        for (int i = 1; i < scores.length; i++) {
            int j = i - 1;
            if (scores[j] < scores[i]) {
                rewards[i] = rewards[j] + 1;
            } else {
                while (j >= 0 && scores[j] > scores[j + 1]) {
                    rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
                    j--;
                }
            }
        }

        return Arrays.stream(rewards).sum();
    }

    public static int minRewards1(int[] scores) {
        if (scores == null || scores.length == 0) return 0;
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);

        List<Integer> lowerIdxs = getLowerIdxs(scores);
        for (int idx : lowerIdxs) {
            expandLowerIdxs(idx, scores, rewards);
        }

        return Arrays.stream(rewards).sum();
    }

    private static void expandLowerIdxs(int idx, int[] scores, int[] rewards) {
        int l = idx - 1;
        while (l >= 0 && scores[l] > scores[l + 1]) {
            rewards[l] = Math.max(rewards[l], rewards[l + 1] + 1);
            l--;
        }

        int r = idx + 1;
        while (r < scores.length && scores[r - 1] < scores[r]) {
            rewards[r] = rewards[r - 1] + 1;
            r++;
        }
    }

    private static List<Integer> getLowerIdxs(int[] scores) {
        List<Integer> lowerIdxs = new ArrayList<>();
        if (scores.length == 1) {
            lowerIdxs.add(scores[0]);
            return lowerIdxs;
        }

        for (int i = 0; i < scores.length; i++) {
            if (i == 0 && scores[i] > scores[i + 1]) lowerIdxs.add(i);
            if (i == scores.length - 1 && scores[i - 1] > scores[i]) lowerIdxs.add(i);
            if (i == 0 || i == scores.length - 1) continue;
            if (scores[i - 1] > scores[i] && scores[i] < scores[i + 1]) lowerIdxs.add(i);
        }
        return lowerIdxs;
    }

    public static int minRewards2(int[] scores) {
        if (scores == null || scores.length == 0) return 0;
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);

        for (int i = 1; i < scores.length; i++) {
            if (scores[i - 1] < scores[i]) {
                rewards[i] = rewards[i - 1] + 1;
            }
        }

        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
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
