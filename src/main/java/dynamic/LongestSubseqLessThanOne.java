package dynamic;

import java.util.Arrays;

public class LongestSubseqLessThanOne {

    public static int[] lslo(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {0, 0, 0};

        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] dp = new int[arr.length];
        int[][] minMax = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            int min = arr[i];
            int max = arr[i];
            for (int j = i + 1; j < arr.length; j++) {

                int diff = Math.abs(arr[j] - min);
                min = Math.min(min, arr[j]);

                if (diff <= 1) {
                    dp[i]++;
                    max = Math.max(max, arr[j]);
                    minMax[i] = new int[] {min, max};
                }
            }
        }

//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.deepToString(minMax));

        int maxV = 0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxV) {
                maxV = dp[i];
                min = minMax[i][0];
                max = minMax[i][1];
            }
        }
        return new int[] {maxV, min, max};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7,8,3,2,2,2,2,2,2,1,1, 3,3,3};

        System.out.println(Arrays.toString(lslo(arr)));
    }
}
