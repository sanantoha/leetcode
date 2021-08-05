package top.interview.question.easy.array;

import java.util.Arrays;

/**
 * Intersection of Two Arrays II
 *
 * Solution
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 *
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's mcoef is small compared to nums2's mcoef? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

class Solution5 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[Math.max(nums1.length, nums2.length)];

        while (i < nums1.length && j < nums2.length) {
            int v1 = nums1[i];
            int v2 = nums2[j];
            if (v1 < v2) {
                i++;
            } else if (v1 > v2) {
                j++;
            } else {
                res[k] = v1;
                i++;
                j++;
                k++;
            }

        }

        return Arrays.copyOf(res, k);
    }
}

public class IntersectTwoArrays {
    public static void main(String[] args) {
        Solution5 s = new Solution5();

        int[] nums1 = { 1,2,2,1 };
        int[] nums2 = {2,2};

        System.out.println(Arrays.toString(s.intersect(nums1, nums2)));

        System.out.println("=================================");

        int[] nums3 = { 4,9,5 };
        int[] nums4 = {9,4,9,8,4};

        System.out.println(Arrays.toString(s.intersect(nums3, nums4)));
    }
}
