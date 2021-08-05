package top.interview.question.easy.array;

import java.util.Arrays;

class Solution7 {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    swap(nums, i, j);
                }
                j++;
            }
        }
    }
}

public class MoveZeros {
    public static void main(String[] args) {
        Solution7 s = new Solution7();

        int[] nums = {2, 1};

        s.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}
