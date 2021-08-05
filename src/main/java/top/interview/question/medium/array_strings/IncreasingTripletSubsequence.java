package top.interview.question.medium.array_strings;

import java.util.Arrays;

class Solution5 {
    public boolean increasingTriplet0(int[] nums) {
        if (nums.length == 0) return false;

        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[i] + 1;
                }
            }
        }

        int max = 0;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        return max > 2;
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;

        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < minOne) {
                minOne = num;
            }

            if (num > minOne) {
                minTwo = Math.min(num, minTwo);
            }

            if (num > minTwo) {
                return true;
            }
        }

        return false;
    }
}

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        Solution5 s = new Solution5();

//        System.out.println(s.increasingTriplet(new int[]{1,2,3,4,5}));
//
//        System.out.println(s.increasingTriplet(new int[]{5,4,3,2,1}));
//
//        System.out.println(s.increasingTriplet(new int[]{2,1,5,0,4,6}));

        System.out.println(s.increasingTriplet(new int[]{100,10,45,20,30,6}));

//        System.out.println(s.increasingTriplet(new int[]{6,7,1,2}));
    }
}
