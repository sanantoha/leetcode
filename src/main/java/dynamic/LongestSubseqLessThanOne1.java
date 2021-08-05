package dynamic;

import java.util.Arrays;

public class LongestSubseqLessThanOne1 {

    public static int[] lslo(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {0, 0, 0};

        Arrays.sort(arr);

        int[] dp = new int[arr.length];
        dp[0] = 1;
        int[][] minMax = new int[arr.length][2];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            int min = arr[i];
            int max = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int diff = Math.abs(arr[j] - min);
                min = Math.min(arr[j], min);
                if (diff <= 1) {
                    dp[i]++;
                    max = Math.max(arr[j], max);
                    minMax[i] = new int[] {min, max};
                }
            }
        }

        int len = 0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (len < dp[i]) {
                len = dp[i];
                min = minMax[i][0];
                max = minMax[i][1];
            }
        }

        return new int[] {len, min, max};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7,8,3,2,2,2,2,2,2,1,1, 3,3,3};

        System.out.println(Arrays.toString(lslo(arr)));
    }
}
