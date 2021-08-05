package top.interview.question.easy.design;

import java.util.Arrays;
import java.util.Random;

class Solution0 {

    private final int[] nums;

    private final Random rand = new Random();

    public Solution0(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < arr.length - 1; i++) {
            int rind = i + rand.nextInt(arr.length - i);
            swap(arr, i, rind);
        }

        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

public class ShuffleArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Solution0 s = new Solution0(arr);

        System.out.println(Arrays.toString(s.reset()));

        System.out.println(Arrays.toString(s.shuffle()));

        System.out.println(Arrays.toString(s.reset()));
    }
}
