package top.interview.question.easy.array;

import java.util.Arrays;

/**
 * Rotate Array
 *
 * Solution
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 *
 * Follow up:
 *
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */


class Solution2 {
    public void rotate(int[] nums, int k) {
        int[] arrCopy = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < nums.length; i++) {
            int newIndex = (i + k) % nums.length;
            nums[newIndex] = arrCopy[i];
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public void rotate0(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = (i + k) % nums.length;
            swap(nums, newIndex, i);
        }
    }
}

public class RotateArray {
    public static void main(String[] args) {

        Solution2 s = new Solution2();


        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        s.rotate(arr1, 3);
        System.out.println(Arrays.toString(arr1));

        System.out.println("===================");

        int[] arr2 = {-1,-100,3,99};
        s.rotate(arr2, 2);
        System.out.println(Arrays.toString(arr2));


        System.out.println("===================");

        int[] arr3 = {1, 2, 3};
        s.rotate(arr3, 2);
        System.out.println(Arrays.toString(arr3));
    }
}
