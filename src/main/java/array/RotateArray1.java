package array;

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

public class RotateArray1 {

    public static void rotate(int[] arr, int k) {

    }

    public static void rotate1(int[] arr, int k) {

    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr1, 3);
        System.out.println(Arrays.toString(arr1)); // [5, 6, 7, 1, 2, 3, 4]

        int[] arr11 = {1, 2, 3, 4, 5, 6, 7};
        rotate1(arr11, 3);
        System.out.println(Arrays.toString(arr11)); // [5, 6, 7, 1, 2, 3, 4]

        System.out.println("===================");

        int[] arr2 = {-1,-100,3,99};
        rotate(arr2, 2);
        System.out.println(Arrays.toString(arr2)); // [3, 99, -1, -100]
        int[] arr22 = {-1,-100,3,99};
        rotate1(arr22, 2);
        System.out.println(Arrays.toString(arr22)); // [3, 99, -1, -100]


        System.out.println("===================");

        int[] arr3 = {1, 2, 3};
        rotate(arr3, 2);
        System.out.println(Arrays.toString(arr3)); // [2, 3, 1]

        int[] arr33 = {1, 2, 3};
        rotate1(arr33, 2);
        System.out.println(Arrays.toString(arr33)); // [2, 3, 1]
    }
}
